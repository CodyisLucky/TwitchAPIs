package com.codypetrick.TwitchChatCommandAPIs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BDOGrindSpots {

    @GetMapping("Twitch/Etain/BDOgrindSpots/{input}")
    @ResponseBody
    public String grindSpots(@PathVariable("input") String stringInput){

        boolean apCheck = true;


        String numberOnly = stringInput.replaceAll("[^0-9]", "");
        int ap = 0;
        String returnString = "";


        if (numberOnly.equals(null) || numberOnly.equals("")){
            apCheck = false;
        }
        else {
            ap = Integer.parseInt(numberOnly);
        }


        if (apCheck){
            boolean offhand = false;

            if(stringInput.toLowerCase().contains("nouver".toLowerCase()) || stringInput.toLowerCase().contains("n".toLowerCase())){
                offhand = true;
            }

            if (offhand){
                if (ap >= 261 && ap < 273){
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
        else{
            String lettersOnly = stringInput.replaceAll("[0-9]", "");

            if(lettersOnly.toLowerCase().contains("Mirumok".toLowerCase()) || lettersOnly.toLowerCase().contains("Trees".toLowerCase())){
                returnString = "Mirumok Ruins has a recommended AP of 235 AP and 284 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Bloody Monastery".toLowerCase()) || lettersOnly.toLowerCase().equalsIgnoreCase("BM")){
                returnString = "Elvia Bloody Monastery has a recommended AP of 269 AP and 329 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Hystria".toLowerCase())){
                returnString = "Hystria Ruins has a recommended AP of 253 AP and 308 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Aakman".toLowerCase())){
                returnString = "Aakman Temple has a recommended AP of 245 AP and 301 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Imps".toLowerCase())){
                returnString = "Elvia Altar Imps has a recommended AP of 261 AP and 315 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Kratuga".toLowerCase())){
                returnString = "Kratuga Ancient Ruins has a recommended AP of 253 AP and 308 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Biraghi".toLowerCase())){
                returnString = "Elvia Biraghi Den has a recommended AP of 261 AP and 315 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Thornwood".toLowerCase()) || lettersOnly.toLowerCase().equalsIgnoreCase("TW")){
                returnString = "Thornwood Forest has a recommended AP of 261 AP and 315 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Stars".toLowerCase()) || lettersOnly.toLowerCase().equalsIgnoreCase("SE")){
                returnString = "Star's End has a recommended AP of 261 AP and 315 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Fogan".toLowerCase())){
                returnString = "Elvia Swamp Fogans has a recommended AP of 265 AP and 322 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Naga".toLowerCase())){
                returnString = "Elvia Swamp Nagas has a recommended AP of 265 AP and 322 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Gyfin".toLowerCase())){
                returnString = "Gyfin Rhasia Temple has a recommended AP of 269 AP and 329 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Padix".toLowerCase())){
                returnString = "Padix Island has a recommended AP of 265 AP and 322 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Turo".toLowerCase())){
                returnString = "Tunkata has a recommended AP of 269 AP and 329 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Castle Ruins".toLowerCase()) || lettersOnly.toLowerCase().equalsIgnoreCase("CR")){
                returnString = "Elvia Castle Ruins has a recommended AP of 269 AP and 329 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Abandoned Monastery".toLowerCase()) || lettersOnly.toLowerCase().equalsIgnoreCase("AM")){
                returnString = "Abandoned Monastery has a recommended AP of 269 AP and 329 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Sycraia".toLowerCase()) || lettersOnly.toLowerCase().contains("Underwater".toLowerCase()) || lettersOnly.toLowerCase().equalsIgnoreCase("UW")){
                returnString = "Sycraia Abyssal Ruins has a recommended AP of 269 AP and 329 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Orc".toLowerCase())){
                returnString = "Elvia Orc Camp has a recommended AP of 281 AP and 347 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Olun".toLowerCase())){
                returnString = "Olun's Valley has a recommended AP of 289 AP and 359 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Ash".toLowerCase())){
                returnString = "Ash Forest has a recommended AP of 289 AP and 359 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Crypt".toLowerCase())){
                returnString = "Crypt of Resting Thoughts has a recommended AP of 301 AP and 401 DP.";
            }
            else {
                returnString = "Please enter a valid location or AP";
            }
            return returnString;

        }




    }


}
