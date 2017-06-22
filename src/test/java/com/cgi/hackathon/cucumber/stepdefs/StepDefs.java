package com.cgi.hackathon.cucumber.stepdefs;

import com.cgi.hackathon.TheaApp;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.boot.test.context.SpringBootTest;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = TheaApp.class)
public abstract class StepDefs {

    protected ResultActions actions;

}
