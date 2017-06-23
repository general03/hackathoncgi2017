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
        symptList.add("Abscence de sécrétion");
        symptList.add("Rougeur blocalisée en nappe unilatérale");
        symptList.add("Rougeur d'apparition brusque");
        symptList.add("Sans traumatisme ni douleur ni larmolement");
        setSymptomes(symptList);

        List<String> condList = new ArrayList<>();
        condList.add("Lavage oculaire");
        condList.add("Instiller un collyre à vise vasculo-portectice");
        condList.add("Rassurer le patient généralement inquiet");
        setConduites(condList);

        setUrlImage("images/fragilite-capillaire-conjonctivale.png");
    }
}
