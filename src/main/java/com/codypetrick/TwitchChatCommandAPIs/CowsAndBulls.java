package com.codypetrick.TwitchChatCommandAPIs;

/*
To Do List:
For Guess make sure incoming int is less than 1000 and positive
Figure out if a linked list will work for multiple channels or if a SQL server is needed
if SQL server is needed, figure out how to implement that on Heroku
 */

import java.util.Random;

public class CowsAndBulls {

    private boolean isActiveGame = false;
    private int[] chosenNum = new int[3];
    private String channel;
    private int guesses;

    public CowsAndBulls(String channel) {
        Random random = new Random();
        this.chosenNum[0] = (random.nextInt(10));
        this.chosenNum[1] = (random.nextInt(10));
        this.chosenNum[2] = (random.nextInt(10));
        this.channel = channel;
        this.isActiveGame = true;
        this.guesses = 0;
    }

    public String guess(int number){

        int[] guessNum = new int[3];
        int cows = 0;
        int bulls = 0;
        int originalNumber = number;
        if(number < 100) {
            guessNum[0] = 0;
        }
        else {
            guessNum[0] = (number/100);
            number = number - (guessNum[0] * 100);
        }
        guessNum[1] = (number / 10);
        guessNum[2] = (number % 10);

        for(int i = 0; i < 3; i++){
            if (guessNum[i] == chosenNum[i]){
                bulls++;
            }
            else if (guessNum[i] == chosenNum[0] || guessNum[i] == chosenNum[1] || guessNum[i] == chosenNum[2]){
                cows++;
            }

        }

        this.guesses++;

        if (bulls == 3){
            this.isActiveGame = false;
            return ("Congratulations you guessed the number! It took you all " + guesses + " guesses.");
        }
        else{
            return ("Your guess of " + originalNumber + " gave you " + cows + " cows and " + bulls + " bulls.");
        }

    }

    public boolean isActiveGame() {
        return isActiveGame;
    }

    public String getChannel() {
        return channel;
    }
}
