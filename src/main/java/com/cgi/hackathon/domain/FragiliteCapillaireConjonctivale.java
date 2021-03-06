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
        symptList.add("Rougeur localisée en nappe unilatérale");
        symptList.add("Rougeur d'apparition brusque");
        symptList.add("Sans traumatisme, ni douleur, ni larmoiement");
        setSymptomes(symptList);

        List<String> condList = new ArrayList<>();
        condList.add("Lavage oculaire");
        condList.add("Instiller un collyre à visé vasculo-protectrice");
        condList.add("Rassurer le patient généralement inquiet");
        setConduites(condList);

        setConseilPrincipal("Consulter un médecin si persistance des symptômes au-delà des 48 h");

        List<String> symptConseilList = new ArrayList<>();
        setConseilSymptome(symptConseilList);

        List<String> risqueConseilList = new ArrayList<>();
        setConseilSymptome(risqueConseilList);

        setHasOsdi(false);

        setUrlImage("/content/images/frag_cap.png");
    }
}
