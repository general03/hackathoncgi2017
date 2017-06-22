package com.cgi.hackathon.web.rest;

import com.cgi.hackathon.domain.*;
import com.cgi.hackathon.service.BotService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gouttebessisg on 22/06/2017.
 */
@RestController
@RequestMapping("/api")
public class PathologieResource {

    public PathologieResource() {

    }

    @GetMapping("/pathologie")
    public Pathogene getPathologie(@ApiParam String message) {
        if("Conjonctivite bactérienne".equalsIgnoreCase(message)) {
            return new ConjonctiviteBacterienne();
        } else if ("Conjonctivite virale".equalsIgnoreCase(message)) {
            return new ConjonctiviteVirale();
        } else if ("Conjonctivite allergique".equalsIgnoreCase(message)) {
            return new ConjonctiviteAllergique();
        } else if ("Fragilité capillaire conjonctivale".equalsIgnoreCase(message)) {
            return new FragiliteCapillaireConjonctivale();
        } else if ("Sécheresse oculaire".equalsIgnoreCase(message)) {
            return new SecheresseOculaire();
        } else if ("Irritations conjonctivales chroniques non infectieuses".equalsIgnoreCase(message)) {
            return new IrritationConjonctivaleChroniqueNonInfectieuse();
        } else {
            return new Pathogene();
        }
    }
}
