package com.cgi.hackathon.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guelerauda on 22/06/2017.
 */
public class IrritationConjonctivaleChroniqueNonInfectieuse extends Pathogene {

    public IrritationConjonctivaleChroniqueNonInfectieuse () {
        setNom("Irritations conjonctivales chroniques non infectieuses");

        List<String> symptList = new ArrayList<>();
        symptList.add("Absence de sécrétion");
        symptList.add("Rougeur diffuse légère uni ou bilatérale");
        symptList.add("Exposition à un agent irritant (soleil, piscine)");
        symptList.add("Petit larmoiement");
        symptList.add("Picotements");
        setSymptomes(symptList);

        List<String> condList = new ArrayList<>();
        condList.add("[1] Lavage oculaire");
        condList.add("[2] Instiller un collyre anti-irritation");
        setConduites(condList);

        setConseilPrincipal("Consulter un médecin si persistance des symptômes au-delà des 48 h");

        List<String> symptConseilList = new ArrayList<>();
        setConseilSymptome(symptConseilList);

        List<String> risqueConseilList = new ArrayList<>();
        setConseilSymptome(risqueConseilList);

        setUrlImage("images/irritation-conjonctivale-chronique-non-infectieuse.png");
    }
}
