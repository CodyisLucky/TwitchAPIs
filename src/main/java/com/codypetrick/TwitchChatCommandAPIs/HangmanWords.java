package com.codypetrick.TwitchChatCommandAPIs;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangmanWords {

    static List<String> wordList = new ArrayList<String>();
    static int listSize = 10;

    public void populateWordList() throws IOException{

        String currWord = "";
        URL url = getClass().getResource("com/codypetrick/TwitchChatCommandAPIs/HangmanWordList.txt");
        File inFile = new File(url.getPath());
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

    public  String getWord() throws IOException{
        Random random = new Random();
        int wordNum = random.nextInt(listSize);
        if(wordList.isEmpty()){
            populateWordList();
        }
        return wordList.get(wordNum);
    }
}
