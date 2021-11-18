package com.codypetrick.test;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class LocalDateTimeDisplay {

    @GetMapping(path = "/displayCurrentTime")
    public String displayCurrentTime(){
        return LocalDateTime.now().toString();
    }


}
