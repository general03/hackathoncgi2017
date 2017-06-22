package com.cgi.hackathon.domain;

import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

/**
 * Created by guelerauda on 22/06/2017.
 */
public class WatsonResponse {
    private MessageResponse context;
    private String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public MessageResponse getContext() {
        return context;
    }

    public void setContext(MessageResponse context) {
        this.context = context;
    }
}
