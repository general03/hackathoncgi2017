package com.cgi.hackathon.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guelerauda on 22/06/2017.
 */
public class SecheresseOculaire extends Pathogene{

    public SecheresseOculaire () {
        setNom("Sécheresse oculaire");

        List<String> symptList = new ArrayList<>();
        symptList.add("Absence de sécrétion");
        symptList.add("Rougeur diffuse légère uni ou bilatérale");
        symptList.add("Larmoiement/grain de sable");
        symptList.add("Sensation d'oeil sec");
        symptList.add("Picotements");
        symptList.add("Clignement des paupières");
        setSymptomes(symptList);

        List<String> condList = new ArrayList<>();
        condList.add("[1] Lavage oculaire");
        condList.add("[2] Instiller un substitut lacrymal");
        setConduites(condList);

        setConseilPrincipal(null);

        List<String> symptConseilList = new ArrayList<>();
        setConseilSymptome(symptConseilList);

        List<String> risqueConseilList = new ArrayList<>();
        setConseilSymptome(risqueConseilList);

        setUrlImage("images/secheresse-oculaire.png");
    }
}
