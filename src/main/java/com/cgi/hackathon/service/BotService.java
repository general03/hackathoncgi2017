package com.cgi.hackathon.service;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by gouttebessisg on 22/06/2017.
 */
@Service
public class BotService {

    private static final String WORKSPACE_ID = "dfd5a50a-8252-4b2f-8c07-ccba0596d21c";
    private static final String USERNAME = "ab5edea0-1d58-4bdc-8db2-bc7fcdf01f8b";
    private static final String PWD = "0olru7MVhpEE";
    private static final String CONVERSATION_VERSION = ConversationService.VERSION_DATE_2017_02_03;

    public MessageResponse interact(Map<String,Object> context, String message ) {

        ConversationService service = new ConversationService(CONVERSATION_VERSION);
        service.setUsernameAndPassword(BotService.USERNAME, BotService.PWD);

        MessageRequest newMessage = new MessageRequest.Builder()
            .inputText(message)
            .context(context)
            .build();

        return service.message(BotService.WORKSPACE_ID, newMessage).execute();
    }

    public MessageResponse initContext() {

        ConversationService service = new ConversationService(CONVERSATION_VERSION);
        service.setUsernameAndPassword(BotService.USERNAME, BotService.PWD);

        MessageRequest newMessage = new MessageRequest.Builder()
            .inputText("")
            .build();

        return service.message(BotService.WORKSPACE_ID, newMessage).execute();
    }
}
