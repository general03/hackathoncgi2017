package com.cgi.hackathon.service;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by gouttebessisg on 22/06/2017.
 */
@Service
public class BotService {

    public String readMessages() {

        ConversationService service = new ConversationService(ConversationService.VERSION_DATE_2017_02_03);
        service.setUsernameAndPassword("g.gouttebessis@cgi.com", "hackatonCGI");

        MessageRequest newMessage = new MessageRequest.Builder().inputText("Hi").build();
        MessageResponse response = service.message("workspace-thea", newMessage).execute();
        System.out.println(response);
        return "";
    }
}
