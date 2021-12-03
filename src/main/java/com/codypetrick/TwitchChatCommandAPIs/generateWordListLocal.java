/*
Heroku doesn't work well with reading from a text file. As such I have written this code to output the code
to add the entire word list to an ArrayList as opposed to adding it in a while loop.

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String currWord = "";
        File inFile = new File("HangmanWordList.txt");
        Scanner scanFile = new Scanner(inFile);//.useDelimiter("\r\n");
        String out = "test";



        while (scanFile.hasNext()){
            currWord = scanFile.next();
            System.out.println("wordList.add(" + currWord + ");");
        }

        scanFile.close();
    }
}

 */
