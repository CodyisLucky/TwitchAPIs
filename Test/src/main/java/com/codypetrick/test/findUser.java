package com.codypetrick.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class findUser {

    @GetMapping("getUser/{user}")
    public boolean getCody(@PathVariable("user") String user){
        if(user.equals("Cody")){
            return true;
        }
        else{
            return false;
        }
    }
}
