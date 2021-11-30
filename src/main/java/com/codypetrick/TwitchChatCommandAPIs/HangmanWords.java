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

    public static void populateWordList() throws IOException{

        String currWord = "";
        File inFile = new File(("C:\\Users\\Cody\\Documents\\Code\\APIs\\TwitchAPIs\\src\\main\\resources\\HangmanWordList.txt"));
        //return ("Attempting to read from file in: "+inFile.getCanonicalPath());
        Scanner scanFile = new Scanner(inFile);//.useDelimiter("\r\n");


        wordList.clear();

        while (scanFile.hasNext()){
            currWord = scanFile.next();
            wordList.add(currWord);
            listSize++;
        }

        scanFile.close();

        //return wordList.get(1);
    }

    public static String getWord() throws IOException{
        Random random = new Random();
        int wordNum = random.nextInt(listSize);
        if(wordList.isEmpty()){
            populateWordList();
        }
        return wordList.get(wordNum);
    }
}
