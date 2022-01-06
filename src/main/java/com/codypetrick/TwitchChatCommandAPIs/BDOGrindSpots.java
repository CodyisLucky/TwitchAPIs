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

        boolean offhand = false;

        if(stringap.toLowerCase().indexOf("nouver".toLowerCase()) != -1 || stringap.toLowerCase().indexOf("n".toLowerCase()) != -1){
            offhand = true;
        }

        String numberOnly = stringap.replaceAll("[^0-9]", "");
        int ap;
        String returnString = "";


        if (numberOnly.equals(null) || numberOnly.equals("")){
            return "You can't grind anything with no AP.";
        }
        else {
            ap = Integer.parseInt(numberOnly);
        }

        if (offhand){
            if (ap > 261 && ap < 273){
                ap -= 12;
            }
            else {
                returnString = "Nouver is being used outside it's optimal range. That said, suggested grindspot(s): ";
                ap -= 12;
            }
        }



        if(ap >= 301){
            returnString = returnString + "Congrats, you beat the game, you can grind everywhere, even Crypt of Resting Thoughts.";
        }
        else if(ap >= 289 && ap < 301){
            returnString = returnString + "Olun's Valley (3p) or Ash Forest. 359 DP suggested.";
        }
        else if(ap >= 281 && ap < 289){
            returnString = returnString + "Hadum Orc Camp. 347 DP suggested.";
        }
        else if(ap >= 269 && ap < 281){
            returnString = returnString + "Sycraia Abyssal Ruins, Abandoned Monastery (2p), Hadum Bloody Monastery, Hadum Castle Ruins (2p), or Turos (2p). 329 DP suggested.";
        }
        else if(ap >= 265 && ap < 269){
            returnString = returnString + "Padix Island (2p), Gyfin Rhasia Temple (5p), or Hadum Swamp Nagas/Fogans. 322 DP suggested.";
        }
        else if(ap >= 261 && ap < 265){
            returnString = returnString + "Star's End, Thornwood Forest, Hadum Biraghi Den, Hadum Altar Imps (2p). 315 DP suggested.";
        }
        else if(ap >= 253 && ap < 261){
            returnString = returnString + "Hystria Ruins or Kratuga Ancient Ruins. 308 DP suggested.";
        }
        else if(ap >= 245 && ap < 253){
            returnString = returnString + "Aakman Temple. 301 DP suggested.";
        }
        else if(ap >= 235 && ap < 245){
            returnString = returnString + "Mirumok Ruins (Trees, 3p), Shultz Guard Wharf, Manshaum Forest, Ronaros, Sycraia Ruins, Sherekhan Night. 284 DP suggested.";
        }
        else{
            returnString = returnString + "Focus on enhancing your Naru gear until you reach 235ap.";
        }

        return returnString;



    }


}
