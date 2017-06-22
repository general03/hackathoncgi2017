package com.cgi.hackathon.service;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by gouttebessisg on 22/06/2017.
 */
@Service
public class BotService {

    private static final String WORKSPACE_ID = "de0812fb-6f56-4e39-abe4-06224794710b";
    private static final String USERNAME = "0689bca2-fe9c-405f-bb06-984de3e826cb";
    private static final String PWD = "XG8Kg4KAfuSm";
    private static final String CONVERSATION_VERSION = ConversationService.VERSION_DATE_2017_02_03;

    public MessageResponse interact(MessageResponse context, String message ) {

        ConversationService service = new ConversationService(CONVERSATION_VERSION);
        service.setUsernameAndPassword(BotService.USERNAME, BotService.PWD);

        MessageRequest newMessage = new MessageRequest.Builder()
            .inputText(message)
            .context(context.getContext())
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
