package com.cgi.hackathon.web.rest;

import com.cgi.hackathon.service.BotService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/watson-conversation")
    public MessageResponse interact(@ApiParam MessageResponse context, @ApiParam String message) {
        return watsonService.interact(context, message);
    }

    @GetMapping("/watson-init")
    public MessageResponse initContext() {
        return watsonService.initContext();
    }
}
