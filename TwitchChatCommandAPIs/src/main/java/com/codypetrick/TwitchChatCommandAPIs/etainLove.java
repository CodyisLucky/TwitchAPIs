package com.codypetrick.TwitchChatCommandAPIs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class etainLove {

    @GetMapping("getEtainLove/{user}/{target}")
    public String loveResponse(@PathVariable("user") String user, @PathVariable("target") String target){
        Random random = new Random();
        int messageChance = (random.nextInt(100) + 1); //random number for the secret message
        int percentChance = 5; //percent chance out of 100 of the secret message occurring

        if(messageChance <= percentChance){
            return ("!zz You thought you were in love with " + target + " but no, it was me, Cody!");
        }
        else{
            int lovePercent = (random.nextInt(100) + 1);
            return (user + " is " + lovePercent + " in love with " + target + " etainOhMy");
        }





    }


}
