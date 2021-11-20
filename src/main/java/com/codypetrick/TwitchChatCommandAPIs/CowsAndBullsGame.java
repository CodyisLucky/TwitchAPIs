package com.codypetrick.TwitchChatCommandAPIs;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

@RestController
public class CowsAndBullsGame {

    LinkedList<CowsAndBulls> games = new LinkedList<>();

    @GetMapping("Twitch/Cody/CowsAndBulls/InitializeNewGame/{channel}")
    @ResponseBody
    public String initializeGame(@PathVariable("channel") String channel){


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
    public String makeGuess(@PathVariable("guess") int guess){
        CowsAndBulls channelGame = games.getFirst();
        String response = channelGame.guess(guess);

        return response;
    }

    @GetMapping("Twitch/Cody/CowsAndBulls/ForceEnd/{channel}")
    @ResponseBody
    public String forceEnd(@PathVariable("channel") String channel){
        games.removeLast();
        return ("Game ended.");
    }


}
