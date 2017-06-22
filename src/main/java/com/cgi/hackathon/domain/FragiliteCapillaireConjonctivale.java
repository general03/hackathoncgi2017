package com.cgi.hackathon.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guelerauda on 22/06/2017.
 */
public class FragiliteCapillaireConjonctivale extends Pathogene{

    public FragiliteCapillaireConjonctivale () {
        setNom("Fragilité capillaire conjonctivale");

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

        setUrlImage("images/fragilite-capillaire-conjonctivale.png");
    }
}
