package com.codypetrick.TwitchChatCommandAPIs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class TwitchChatCommandApIsApplication {

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Welcome to Cody's APIs";
	}

	public static void main(String[] args) {
		SpringApplication.run(TwitchChatCommandApIsApplication.class, args);
	}

}
