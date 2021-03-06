package com.codypetrick.TwitchChatCommandAPIs;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Hangman {

    private boolean isActiveGame = false;
    private int guessesRemaining;
    private ArrayList<Character> word = new ArrayList<Character>();
    private ArrayList<Character> guesses = new ArrayList<Character>();
    private ArrayList<Character> guessedLetters = new ArrayList<Character>();
    private String actualWord = "";
    private int wordSize = 0;
    private int correctGuesses = 0;

    public Hangman() throws IOException{
        this.isActiveGame = true;
        this.guessesRemaining = 6;
        wordForGame();
    }

    public void wordForGame() throws IOException {
        Random random = new Random();
        HangmanWords wordTemp = new HangmanWords();
        actualWord = wordTemp.getWord();

        for (char c : actualWord.toCharArray()){
            c = Character.toUpperCase(c);
            word.add(c);
        }

        wordSize = word.size();

        //Build blank guesses
        for (int i = 0; i < wordSize; i++){
            guesses.add(i, '_');
        }

    }

    public String showGuesses(){
        return stringOfGuesses();
    }

    public String guess(char guessChar){
        boolean incorrect = true;
        //Check guess for accuracy, build guess string
        for (int i = 0; i < wordSize; i++){
            if (guessChar == word.get(i)){
                guesses.set(i, guessChar);
                correctGuesses++;
                incorrect = false;
            }
        }

        if(incorrect){
            guessesRemaining--;
        }

        guessedLetters.add(guessChar);

        if (correctGuesses == wordSize){
            this.isActiveGame = false;
            return ("Congratulations, you correctly guess the word!");
        }
        else if (guessesRemaining == 0){
            this.isActiveGame = false;
            return ("Sorry, you did not guess the word in time. The word was " + actualWord + ".");
        }
        else{
            return ("You have " + guessesRemaining + " wrong guesses remaining and " + (wordSize - correctGuesses) + " letters remaining. " +
                    "Currently guessed word is: " + stringOfGuesses() + " -- Guessed letters: " + stringOfGuessedLetters());
        }

    }

    private String stringOfGuesses(){
        StringBuilder builder = new StringBuilder(wordSize);
        for (Character ch: guesses){
            builder.append(ch);
        }
        return builder.toString();
    }

    private String stringOfGuessedLetters(){
        StringBuilder builder = new StringBuilder(wordSize);
        for (Character ch: guessedLetters){
            builder.append(ch);
            builder.append(' ');
        }
        return builder.toString();
    }

    public boolean isActiveGame() {
        return isActiveGame;
    }

    public int getWordSize() {
        return wordSize;
    }

    public ArrayList<Character> getGuessedLetters() {
        return guessedLetters;
    }
}
