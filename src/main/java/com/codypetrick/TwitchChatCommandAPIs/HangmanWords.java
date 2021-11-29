package com.codypetrick.TwitchChatCommandAPIs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangmanWords {

    static List<String> wordList = new ArrayList<String>();
    static int listSize = 10;

    private void populateWordList() throws IOException{

        String currWord = "";
        Scanner inFile = new Scanner(new File("HangmanWordList.txt")).useDelimiter("\r\n");

        wordList.clear();

        while (inFile.hasNext()){
            currWord = inFile.next();
            wordList.add(currWord);
            listSize++;
        }

        inFile.close();
    }

    public static String getWord(){
        Random random = new Random();
        int wordNum = random.nextInt(listSize);
        if(wordList.isEmpty()){
            return "Nowords";
        }
        return wordList.get(wordNum);
    }
}
