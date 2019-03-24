package com.example.fn;

import com.fnproject.fn.api.FnFeature;
import com.fnproject.fn.api.flow.Flow;
import com.fnproject.fn.api.flow.Flows;
import com.fnproject.fn.runtime.flow.FlowFeature;

import java.io.Serializable;
import java.util.logging.Logger;

@FnFeature(FlowFeature.class)
public class CubeFunction implements Serializable {

    Logger logger = Logger.getLogger(CubeFunction.class.getName());

    public CubeReponse handleRequest(CubeCommande cubeCommande) {

        logger.info("handle request, cubeCommande: "  + cubeCommande);

        Flow fl = Flows.currentFlow();

        CubeReponse cubeReponse = fl.completedValue(cubeCommande.valeur)
                .thenApply( valeur ->
                        new CubeReponse(cubeCommande.valeur * cubeCommande.valeur  * cubeCommande.valeur)
                )
                .get();

        logger.info("before sending cubeReponse, cubeReponse: " + cubeReponse);

        return cubeReponse;
    }
}