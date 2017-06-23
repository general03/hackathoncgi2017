package com.cgi.hackathon.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by guelerauda on 22/06/2017.
 */
public class Pathogene implements Serializable{
    public String nom;
    private List<String> symptomes;
    private List<String> conduites;
    private String conseilPrincipal;
    private List<String> conseilSymptome;
    private List<String> conseilRisque;
    private String urlImage;

    public String getConseilPrincipal() {
        return conseilPrincipal;
    }

    public void setConseilPrincipal(String conseilPrincipal) {
        this.conseilPrincipal = conseilPrincipal;
    }

    public List<String> getConseilSymptome() {
        return conseilSymptome;
    }

    public void setConseilSymptome(List<String> conseilSymptome) {
        this.conseilSymptome = conseilSymptome;
    }

    public List<String> getConseilRisque() {
        return conseilRisque;
    }

    public void setConseilRisque(List<String> conseilRisque) {
        this.conseilRisque = conseilRisque;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

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
