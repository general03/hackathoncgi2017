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
        symptList.add("");
        symptList.add("");
        symptList.add("");
        setSymptomes(symptList);

        List<String> condList = new ArrayList<>();
        condList.add("");
        condList.add("");
        condList.add("");
        setConduites(condList);

        setUrlImage("images/conjonctivite-virale.png");
    }
}
