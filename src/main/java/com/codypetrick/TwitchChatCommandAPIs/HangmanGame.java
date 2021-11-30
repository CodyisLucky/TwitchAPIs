package com.codypetrick.TwitchChatCommandAPIs;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

@RestController
public class HangmanGame {

    Hashtable games = new Hashtable();

    @GetMapping("Twitch/Cody/Hangman/InitializeNewGame/{channel}")
    @ResponseBody
    public String initializeGame(@PathVariable("channel") String channel) throws IOException{
        for(int i = 0; i < games.size(); i++){
            if(games.containsKey(channel)){
                return ("A game already exists for this channel");
            }
        }

        games.put(channel, new Hangman());
        Hangman game = (Hangman) games.get(channel);

        return ("The game has begun! The word is: " + game.showGuesses());

    }

    //Iterate through the games and return if a game is already running for the current channel.
    private boolean gameExists(String channel){

        return false;
    }

    @GetMapping("Twitch/Cody/Hangman/MakeGuess/{channel}/{guess}")
    @ResponseBody
    public String makeGuess(@PathVariable("channel") String channel, @PathVariable("guess") String guessString){
        String response = ("No active game found.") ;
        ArrayList<Character> guess = toCharArray(guessString);
        int guessLength = 0;

        if(games.containsKey(channel)){
            switch (validateGuess(guess, channel)){
                case 1: break;
                case 2: case 3: return "Please enter a single letter.";
                case 4: return "This letter has already been guessed, please guess a new one.";
                default: break;
            }
            Hangman channelGame = (Hangman) games.get(channel);
            response = channelGame.guess(guess.get(0));
            if(!channelGame.isActiveGame()){
                games.remove(channel);
                return response;
            }
        }


        return response;
    }

    @GetMapping("Twitch/Cody/Hangman/ForceEnd/{channel}")
    @ResponseBody
    public String forceEnd(@PathVariable("channel") String channel){
        if(games.containsKey(channel)){
            games.remove(channel);
            return("The game has ended.");
        }
        return ("No game found for this channel.");
    }

    @GetMapping("Twitch/Cody/Hangman/GetCurrentWord/{channel}")
    @ResponseBody
    public String showCurrentWord(@PathVariable("channel") String channel){
        Hangman game = (Hangman) games.get(channel);

        return ("The word is: " + game.showGuesses());
    }

    @GetMapping("Twitch/Cody/Hangman/Rules")
    @ResponseBody
    public String rules(){
        return ("The goal of the game is to guess the correct word in as few attempts as possible.");
    }

    @GetMapping("Twitch/Cody/Hangman/UpdateWordList")
    public String updateWordList() throws IOException {
        HangmanWords.populateWordList();
        return "Word list updated.";
    }

    //Returns the String guess as a Character ArrayList.
    private static ArrayList<Character> toCharArray(String guessWord){
        ArrayList<Character> guessChars = new ArrayList<Character>();
        for (char c : guessWord.toCharArray()){
            c = Character.toUpperCase(c);
            guessChars.add(c);
        }
        return guessChars;
    }


    private int validateGuess(ArrayList<Character> guess, String channel){

        ArrayList<Character> guessedLetters = new ArrayList<Character>();
        Hangman channelGame = (Hangman) games.get(channel);
        guessedLetters = channelGame.getGuessedLetters();

        //Guess is more than one letter
        if (guess.size() > 1){
            return 2;
        }

        //Guess is not a letter
        if(!Character.isLetter(guess.get(0))){
            return 3;
        }

        //Guess has already been guessed
        for (int i = 0; i < guessedLetters.size(); i++){
            if (guess.get(0) == guessedLetters.get(i)){
                return 4;
            }
        }

        return 1;


    }


}
