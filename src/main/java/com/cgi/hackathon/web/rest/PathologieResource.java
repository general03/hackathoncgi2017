package com.cgi.hackathon.web.rest;

import com.cgi.hackathon.domain.*;
import com.cgi.hackathon.service.BotService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * Created by gouttebessisg on 22/06/2017.
 */
@RestController
@RequestMapping("/api/pathologie")
public class PathologieResource {

    public PathologieResource() {

    }

    @GetMapping("/ConjonctiviteBacterienne")
    public Pathogene getConjonctiviteBacterienne() {
        return new ConjonctiviteBacterienne();
    }

    @GetMapping("/ConjonctiviteVirale")
    public Pathogene getConjonctiviteVirale() {
        return new ConjonctiviteVirale();
    }

    @GetMapping("/ConjonctiviteAllergique")
    public Pathogene getConjonctiviteAllergique() {
        return new ConjonctiviteAllergique();
    }

    @GetMapping("/FragiliteCapillaireConjonctivale")
    public Pathogene getFragiliteCapillaireConjonctivale() {
        return new FragiliteCapillaireConjonctivale();
    }

    @GetMapping("/IrritationConjonctivaleChroniqueNonInfectieuse")
    public Pathogene getIrritationConjonctivaleChroniqueNonInfectieuse() {
        return new IrritationConjonctivaleChroniqueNonInfectieuse();
    }

    @GetMapping("/SecheresseOculaire")
    public Pathogene getSecheresseOculaire() {
        return new SecheresseOculaire();
    }
}
