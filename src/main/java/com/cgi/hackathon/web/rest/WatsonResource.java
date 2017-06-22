package com.cgi.hackathon.web.rest;

import com.cgi.hackathon.service.BotService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/watson-conversation")
    public MessageResponse interact(@ApiParam MessageResponse context, @ApiParam String message) {
        return watsonService.interact(context, message);
    }

    @GetMapping("/watson-init")
    public MessageResponse initContext() {
        return watsonService.initContext();
    }
}
