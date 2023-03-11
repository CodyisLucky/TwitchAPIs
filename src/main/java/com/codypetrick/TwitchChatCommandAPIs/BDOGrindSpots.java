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



            if (ap >= 310){
                returnString = returnString + "Elvia Quint Hill. 400 DP suggested.";
            }
            else if(ap >= 301 && ap < 310){
                returnString = returnString + "Elvia Hexe Sanctuary, Gyfin Rhasia Underground, or Crypt of Resting Thoughts.  390 DP suggested.";
            }
            else if(ap >= 289 && ap < 301){
                returnString = returnString + "Elvia Primal Giant Post, or Olun's Valley (3p) or Ash Forest. 359 DP suggested.";
            }
            else if(ap >= 281 && ap < 289){
                returnString = returnString + "Winter Tree Fossil, Jade Starlight Forest, Murrowak's Labyrinth, Elvia Orc Camp, or Elvia Rhutum Outstation. 347 DP suggested.";
            }
            else if(ap >= 269 && ap < 281){
                returnString = returnString + "Elvia Saunil Camp, Sycraia Abyssal Ruins, Abandoned Monastery (2p), Elvia Bloody Monastery, Elvia Castle Ruins (2p), or Turos (2p). 329 DP suggested.";
            }
            else if(ap >= 265 && ap < 269){
                returnString = returnString + "Padix Island (2p), Gyfin Rhasia Temple (5p), or Elvia Swamp Nagas/Fogans. 322 DP suggested.";
            }
            else if(ap >= 261 && ap < 265){
                returnString = returnString + "Star's End, Thornwood Forest, Elvia Biraghi Den, Elvia Altar Imps (2p). 315 DP suggested.";
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
                returnString = "Mirumok Ruins is recommended at 235 AP and 284 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Bloody Monastery".toLowerCase()) || lettersOnly.toLowerCase().equalsIgnoreCase("BM")){
                returnString = "Elvia Bloody Monastery is recommended at 269 AP and 329 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Hystria".toLowerCase())){
                returnString = "Hystria Ruins is recommended at 253 AP and 308 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Aakman".toLowerCase())){
                returnString = "Aakman Temple is recommended at 245 AP and 301 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Imps".toLowerCase())){
                returnString = "Elvia Altar Imps is recommended at 261 AP and 315 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Kratuga".toLowerCase())){
                returnString = "Kratuga Ancient Ruins is recommended at 253 AP and 308 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Biraghi".toLowerCase())){
                returnString = "Elvia Biraghi Den is recommended at 261 AP and 315 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Thornwood".toLowerCase()) || lettersOnly.toLowerCase().equalsIgnoreCase("TW")){
                returnString = "Thornwood Forest is recommended at 261 AP and 315 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Stars".toLowerCase()) || lettersOnly.toLowerCase().equalsIgnoreCase("SE")){
                returnString = "Star's End is recommended at 261 AP and 315 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Fogan".toLowerCase())){
                returnString = "Elvia Swamp Fogans is recommended at 265 AP and 322 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Naga".toLowerCase())){
                returnString = "Elvia Swamp Nagas is recommended at 265 AP and 322 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Gyfin".toLowerCase())){
                returnString = "Gyfin Rhasia Temple is recommended at 269 AP and 329 DP. Gyfin Rhasia Underground is recommended at 301 AP an 380 DP";
            }
            else if(lettersOnly.toLowerCase().contains("Padix".toLowerCase())){
                returnString = "Padix Island is recommended at 265 AP and 322 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Turo".toLowerCase())){
                returnString = "Tunkata is recommended at 269 AP and 329 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Castle Ruins".toLowerCase()) || lettersOnly.toLowerCase().equalsIgnoreCase("CR")){
                returnString = "Elvia Castle Ruins is recommended at 269 AP and 329 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Abandoned Monastery".toLowerCase()) || lettersOnly.toLowerCase().equalsIgnoreCase("AM")){
                returnString = "Abandoned Monastery is recommended at 269 AP and 329 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Sycraia".toLowerCase()) || lettersOnly.toLowerCase().contains("Underwater".toLowerCase()) || lettersOnly.toLowerCase().equalsIgnoreCase("UW")){
                returnString = "Sycraia Abyssal Ruins is recommended at 269 AP and 329 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Orc".toLowerCase())){
                returnString = "Elvia Orc Camp is recommended at 281 AP and 347 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Olun".toLowerCase())){
                returnString = "Olun's Valley is recommended at 289 AP and 359 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Ash".toLowerCase())){
                returnString = "Ash Forest is recommended at 289 AP and 359 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Crypt".toLowerCase())){
                returnString = "Crypt of Resting Thoughts is recommended at 301 AP and 401 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Hexe".toLowerCase())){
                returnString = "Elvia Hexe Sanctuary is recommended at 301 AP and 390 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Quint".toLowerCase())){
                returnString = "Elvia Quint Hill is recommended at 310 AP and 401 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Giant".toLowerCase())){
                returnString = "Elvia Primal Giant Post is recommended at 290 AP and 380 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Saunil".toLowerCase())){
                returnString = "Elvia Saunil Camp is recommended at 270 AP and 330 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Winter".toLowerCase())){
                returnString = "Winter Tree Fossil is recommended at 280 AP and 350 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Jade".toLowerCase())){
                returnString = "Jade Starlight Forest is recommended at 280 AP and 350 DP.";
            }
            else if(lettersOnly.toLowerCase().contains("Murrowak".toLowerCase())){
                returnString = "Murrowak's Labyrinth is recommended at 280 AP and 350 DP.";
            }
            else {
                returnString = "Please enter a valid location or AP";
            }
            return returnString;

        }




    }


}
