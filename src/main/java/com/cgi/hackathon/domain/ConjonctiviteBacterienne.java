package com.cgi.hackathon.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guelerauda on 22/06/2017.
 */
public class ConjonctiviteBacterienne extends Pathogene{

    public ConjonctiviteBacterienne () {

        setNom("Conjonctivite bactérienne");

        List<String> symptList = new ArrayList<>();
        symptList.add("Sécrétions purulentes");
        symptList.add("Rougeur diffuse uni ou bilatérale");
        symptList.add("Pus dans l'angle interne");
        symptList.add("Cils agglutinés");
        symptList.add("Paupières collés au réveil");
        setSymptomes(symptList);

        List<String> condList = new ArrayList<>();
        condList.add("[1] Lavage oculaire : nettoyer les sécrétions oculaires");
        condList.add("[2] Instiller un collyre antiseptique");
        setConduites(condList);

        setConseilPrincipal("Conjonctivites bactériennes graves [1] ou en présence de facteurs de risque [2]");

        List<String> symptConseilList = new ArrayList<>();
        symptConseilList.add("Sécrétions abondantes");
        symptConseilList.add("Oedème important des paupières");
        symptConseilList.add("Photophobie");
        setConseilSymptome(symptConseilList);

        List<String> risqueConseilList = new ArrayList<>();
        risqueConseilList.add("Immunodépression");
        risqueConseilList.add("Diabète mal équilibré");
        risqueConseilList.add("Greffe de cornée");
        risqueConseilList.add("Chirurgie oculaire récente");
        risqueConseilList.add("Corticothérapie locale");
        risqueConseilList.add("Lentilles de contact");
        risqueConseilList.add("Obstruction des glandes lacrymales");
        setConseilSymptome(risqueConseilList);

        setUrlImage("images/conjonctivite-bacterienne.png");
    }

}
