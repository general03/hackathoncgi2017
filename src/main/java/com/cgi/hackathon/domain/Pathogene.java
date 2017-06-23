package com.cgi.hackathon.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by guelerauda on 22/06/2017.
 */
public class Pathogene implements Serializable {
    private static String nom;
    private static List<String> symptomes;
    private static List<String> conduites;
    private static String conseilPrincipal;
    private static List<String> conseilSymptome;
    private static List<String> conseilRisque;
    private static String urlImage;
    private static boolean hasOsdi;

    public boolean isHasOsdi() {
        return hasOsdi;
    }

    public void setHasOsdi(boolean hasOsdi) {
        this.hasOsdi = hasOsdi;
    }

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
