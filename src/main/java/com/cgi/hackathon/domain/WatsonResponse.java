package com.cgi.hackathon.domain;

import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

import java.util.Map;

/**
 * Created by guelerauda on 22/06/2017.
 */
public class WatsonResponse {
    private Map<String, Object> context;
    private String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Map<String, Object> getContext() {
        return context;
    }

    public void setContext(Map<String, Object> context) {
        this.context = context;
    }
}
