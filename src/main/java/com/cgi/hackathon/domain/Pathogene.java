package com.cgi.hackathon.domain;

import java.util.List;

/**
 * Created by guelerauda on 22/06/2017.
 */
public class Pathogene {
    private String nom;
    private List<String> symptomes;
    private List<String> conduites;


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<String> getSymptomes() {
        return symptomes;
    }

    public void setSymptomes(List<String> symptomes) {
        this.symptomes = symptomes;
    }

    public List<String> getConduites() {
        return conduites;
    }

    public void setConduites(List<String> conduites) {
        this.conduites = conduites;
    }
}
