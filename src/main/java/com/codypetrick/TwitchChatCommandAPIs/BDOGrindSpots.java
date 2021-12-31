package com.codypetrick.TwitchChatCommandAPIs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BDOGrindSpots {

    @GetMapping("Twitch/Etain/BDOgrindSpots/{ap}")
    @ResponseBody
    public String grindSpots(@PathVariable("ap") String stringap){

        String numberOnly = stringap.replaceAll("[^0-9]", "");
        int ap;

        if (numberOnly.equals(null) || numberOnly.equals("")){
            return "You can't grind anything with no AP.";
        }
        else {
            ap = Integer.parseInt(numberOnly);
        }



        if(ap >= 301){
            return "Congrats, you beat the game, you can grind everywhere, even Crypt of Resting Thoughts.";
        }
        else if(ap >= 289 && ap < 301){
            return "Olun's Valley (3p) or Ash Forest.";
        }
        else if(ap >= 281 && ap < 289){
            return "Hadum Orc Camp.";
        }
        else if(ap >= 269 && ap < 281){
            return "Sycraia Abyssal Ruins, Abandoned Monastery (2p), Hadum Bloody Monastery, Hadum Castle Ruins (2p), or Turos (2p).";
        }
        else if(ap >= 265 && ap < 269){
            return "Padix Island (2p), Gyfin Rhasia Temple (5p), or Hadum Swamp Nagas/Fogans.";
        }
        else if(ap >= 261 && ap < 265){
            return "Star's End, Thornwood Forest, Hadum Biraghi Den, Hadum Altar Imps (2p).";
        }
        else if(ap >= 253 && ap < 261){
            return "Hystria Ruins or Kratuga Ancient Ruins.";
        }
        else if(ap >= 245 && ap < 253){
            return "Aakman Temple";
        }
        else if(ap >= 235 && ap < 245){
            return "Mirumok Ruins (Trees, 3p), Shultz Guard Wharf, Manshaum Forest, Ronaros, Sycraia Ruins, Sherekhan Night.";
        }
        else{
            return "Focus on enhancing your Naru gear until you reach 235ap.";
        }



    }


}
