package com.codypetrick.TwitchChatCommandAPIs;

/*
To Do List:
Write the constructor, guess, and force end command methods
For Guess make sure incoming int is less than 1000 and positive
Figure out if a linked list will work for multiple channels or if a SQL server is needed
if SQL server is needed, figure out how to implement that on Heroku
 */

public class CowsAndBulls {

    private boolean isActiveGame = false;
    private int firstNum;
    private int secondNum;
    private int thirdNum;
    private String channel;
    private int guesses;

    public CowsAndBulls(int firstNum, int secondNum, int thirdNum, String channel) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
        this.thirdNum = thirdNum;
        this.channel = channel;
        this.isActiveGame = true;
        this.guesses = 0;
    }

    public boolean guess(int number){
        if(number < 100) {
            firstNum = 0;
        }
        else {
            firstNum = (number/100);
            number = number = (firstNum * 100);
        }
         secondNum = (number / 10);
         thirdNum = 


    }
}
