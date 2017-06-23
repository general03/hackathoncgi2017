package com.cgi.hackathon.web.rest;

import com.cgi.hackathon.domain.*;
import com.cgi.hackathon.service.BotService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * Created by gouttebessisg on 22/06/2017.
 */
@RestController
@RequestMapping("/api")
public class PathologieResource {

    public PathologieResource() {

    }

    @GetMapping("/pathologie/{namePatho}")
    public Pathogene getPathologie(@PathParam("namePatho") String namePatho) {
        if("ConjonctiviteBacterienne".equalsIgnoreCase(namePatho)) {
            return new ConjonctiviteBacterienne();
        } else if ("ConjonctiviteVirale".equalsIgnoreCase(namePatho)) {
            return new ConjonctiviteVirale();
        } else if ("ConjonctiviteAllergique".equalsIgnoreCase(namePatho)) {
            return new ConjonctiviteAllergique();
        } else if ("FragiliteCapillaireConjonctivale".equalsIgnoreCase(namePatho)) {
            return new FragiliteCapillaireConjonctivale();
        } else if ("SecheresseOculaire".equalsIgnoreCase(namePatho)) {
            return new SecheresseOculaire();
        } else if ("IrritationConjonctivaleChroniqueNonInfectieuse".equalsIgnoreCase(namePatho)) {
            return new IrritationConjonctivaleChroniqueNonInfectieuse();
        } else {
            return new Pathogene();
        }
    }
}
