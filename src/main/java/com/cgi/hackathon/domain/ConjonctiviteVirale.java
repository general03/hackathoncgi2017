package com.cgi.hackathon.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guelerauda on 22/06/2017.
 */
public class ConjonctiviteVirale extends Pathogene{

    public ConjonctiviteVirale () {
        setNom("Conjonctivite virale");

        List<String> symptList = new ArrayList<>();
        symptList.add("Sécrétions claires");
        symptList.add("Rougeur diffuse uni ou bilatérale");
        symptList.add("Oeil très larmoyant");
        symptList.add("Oedème palpébral");
        symptList.add("Notion d'épidémie : rhume, angine");
        setSymptomes(symptList);

        List<String> condList = new ArrayList<>();
        condList.add("Lavage oculaire : nettoyer les sécrétions oculaires");
        condList.add("Instiller un collyre antiseptique");
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
        setConseilRisque(risqueConseilList);

        setHasOsdi(false);

        setUrlImage("/content/images/conj_vir.png");
    }
}
