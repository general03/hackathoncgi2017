package com.cgi.hackathon.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guelerauda on 22/06/2017.
 */
public class ConjonctiviteAllergique extends Pathogene{

    public ConjonctiviteAllergique () {
        setNom("Conjonctivite allergique");

        List<String> symptList = new ArrayList<>();
        symptList.add("Sécrétions claires");
        symptList.add("Rougeur bilatérale et larmoiement");
        symptList.add("Prurit très important paupières et angle interne");
        symptList.add("Saison pollinique");
        symptList.add("Rhinite allergique");
        setSymptomes(symptList);

        List<String> condList = new ArrayList<>();
        condList.add("[1] Rechercher et supprimer dans la mesure du possible l'allergène");
        condList.add("[2] Lavage oculaire : laver abondamment les culs-de-sac conjonctivaux");
        condList.add("[3] Instiller un collyre antiallergique");
        setConduites(condList);

        setConseilPrincipal("Consulter un médecin si persistance des symptômes au-delà des 48 h");

        List<String> symptConseilList = new ArrayList<>();
        setConseilSymptome(symptConseilList);

        List<String> risqueConseilList = new ArrayList<>();
        setConseilSymptome(risqueConseilList);

        setHasOsdi(false);

        setUrlImage("/content/images/conj_all.png");
    }
}
