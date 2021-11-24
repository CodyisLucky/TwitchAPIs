package com.codypetrick.TwitchChatCommandAPIs;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Hashtable;

@RestController
public class CowsAndBullsGame {

    Hashtable games = new Hashtable();

    @GetMapping("Twitch/Cody/CowsAndBulls/InitializeNewGame/{channel}")
    @ResponseBody
    public String initializeGame(@PathVariable("channel") String channel){
        for(int i = 0; i < games.size(); i++){
            if(games.containsKey(channel)){
                return ("A game already exists for this channel");
            }
        }

        games.put(channel, new CowsAndBulls());
        CowsAndBulls game = (CowsAndBulls) games.get(channel);

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
            if(games.containsKey(channel)){
                CowsAndBulls channelGame = (CowsAndBulls) games.get(channel);
                response = channelGame.guess(guess);
                if(!channelGame.isActiveGame()){
                    games.remove(channel);
                    return response;
                }
            }


        return response;
    }

    @GetMapping("Twitch/Cody/CowsAndBulls/ForceEnd/{channel}")
    @ResponseBody
    public String forceEnd(@PathVariable("channel") String channel){
        if(games.containsKey(channel)){
            games.remove(channel);
            return("The game has ended.");
        }
        return ("No game found for this channel.");
    }

    @GetMapping("Twitch/Cody/CowsAndBulls/Rules")
    @ResponseBody
    public String rules(){
        return ("The goal of the game is to guess the 3 digit number in as few attempts as possible." +
                " If you guess a correct number in the wrong place, you get a cow. If you guess the correct number and place " +
                "you get a bull.");
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
