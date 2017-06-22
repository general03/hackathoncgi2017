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
        symptList.add("");
        symptList.add("");
        symptList.add("");
        setSymptomes(symptList);

        List<String> condList = new ArrayList<>();
        condList.add("");
        condList.add("");
        condList.add("");
        setConduites(condList);

        setUrlImage("images/irritation-conjonctivale-chronique-non-infectieuse.png");
    }
}
