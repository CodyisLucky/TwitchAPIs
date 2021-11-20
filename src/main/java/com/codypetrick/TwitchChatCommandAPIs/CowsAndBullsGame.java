package com.codypetrick.TwitchChatCommandAPIs;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CowsAndBullsGame {

    ArrayList<CowsAndBulls> games = new ArrayList<>();

    @GetMapping("Twitch/Cody/CowsAndBulls/InitializeNewGame/{channel}")
    @ResponseBody
    public String initializeGame(@PathVariable("channel") String channel){
        for(int i = 0; i < games.size(); i++){
            if(games.get(i).getChannel().equals(channel)){
                return ("A game already exists for this channel");
            }
        }

        CowsAndBulls newGame = new CowsAndBulls(channel);
        games.add(newGame);

        return ("The game has begun!");

    }

    //Iterate through the games and return if a game is already running for the current channel.
    private boolean gameExists(String channel){

        return false;
    }

    @GetMapping("Twitch/Cody/CowsAndBulls/MakeGuess/{channel}/{guess}")
    @ResponseBody
    public String makeGuess(@PathVariable("channel") String channel, @PathVariable("guess") String guessString){
        String response = ("No active game found.") ;
        int guess = toInt(guessString);

        if(guess > 999 || guess < 0){
            return "Invalid guess. Must be a positive number less than 1000.";
        }
        for(int i = 0; i < games.size(); i++){
            if(games.get(i).getChannel().equals(channel)){
                CowsAndBulls channelGame = games.get(i);
                response = channelGame.guess(guess);
                if(!channelGame.isActiveGame()){
                    games.remove(i);
                    return response;
                }
            }
        }

        return response;
    }

    @GetMapping("Twitch/Cody/CowsAndBulls/ForceEnd/{channel}")
    @ResponseBody
    public String forceEnd(@PathVariable("channel") String channel){
        for(int i = 0; i < games.size(); i++){
            if(games.get(i).getChannel().equals(channel)){
                games.remove(i);
                return("The game has ended.");
            }
        }
        return ("No game found for this channel.");
    }

    //Validates that the guess is a valid numeric value, returns -1 if it is not.
    public static int toInt(String strNum){
        if (strNum == null) {
            return -1;
        }
        try {
            int i = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return -1;
        }
        return Integer.parseInt(strNum);
    }


}
