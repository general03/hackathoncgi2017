package com.cgi.hackathon.web.rest;

import com.cgi.hackathon.service.BotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gouttebessisg on 22/06/2017.
 */
@RestController
@RequestMapping("/api")
public class WatsonResource {

    private final BotService watsonService;

    public WatsonResource (BotService watsonService) {
        this.watsonService = watsonService;
    }

    @GetMapping("/watson")
    public String readMessages() {
        return watsonService.readMessages();
    }
}
