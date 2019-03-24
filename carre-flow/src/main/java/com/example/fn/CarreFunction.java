package com.example.fn;

import com.fnproject.fn.api.FnFeature;
import com.fnproject.fn.api.flow.Flow;
import com.fnproject.fn.api.flow.Flows;
import com.fnproject.fn.runtime.flow.FlowFeature;

import java.io.Serializable;
import java.util.logging.Logger;

@FnFeature(FlowFeature.class)
public class CarreFunction implements Serializable {

    Logger logger = Logger.getLogger(CarreFunction.class.getName());

    public CarreReponse handleRequest(CarreCommande carreCommande) {

        logger.info("handle request, carreCommande: "  + carreCommande);

        Flow fl = Flows.currentFlow();

        CarreReponse carreReponse = fl.completedValue(carreCommande.valeur)
            .thenApply( valeur ->
                 new CarreReponse(carreCommande.valeur * carreCommande.valeur)
            )
            .get();

        logger.info("before sending carreReponse, carreReponse: " + carreReponse);

        return carreReponse;
    }

}