package com.codypetrick.TwitchChatCommandAPIs;

import org.springframework.web.bind.annotation.*;

import java.util.Random;

/*Custom command created by Cody Petrick for twitch.tv/etain
Has an x% chance to output a secret "It was me, Dio" message.
Otherwise, outputs a random love percentage between the user and a given target
 */

@RestController
public class etainLove {

    @GetMapping("Twitch/etainLoveCommand/{user}/{target}")
    @ResponseBody
    public String loveResponse(@PathVariable("user") String user, @PathVariable("target") String target){
        Random random = new Random();
        int messageChance = (random.nextInt(100) + 1); //random number for the secret message
        int percentChance = 5; //percent chance out of 100 of the secret message occurring

        if(messageChance <= percentChance){
            return ("!zz You thought you were in love with " + target + " but no, it was me, Cody!");
        }
        else{
            int lovePercent = (random.nextInt(100) + 1);
            return (user + " is " + lovePercent + "% in love with " + target + " etainKISS etainKISS2");
        }

    }

//    @GetMapping("Twitch/etainLoveCommand/{user}")
//    public String loveResponse(@PathVariable("user") String user){
//        Random random = new Random();
//        int messageChance = (random.nextInt(100) + 1); //random number for the secret message
//        int percentChance = 5; //percent chance out of 100 of the secret message occurring
//
//        if(messageChance <= percentChance){
//            return ("!zz You thought you were in love with yourself but no, it was me, Cody!");
//        }
//        else{
//            int lovePercent = (random.nextInt(100) + 1);
//            return (user + " is " + lovePercent + " in love with themself etainOhMy");
//        }
//
//    }



}
