package com.example.fn;

import com.example.fn.dto.cube.CubeCommande;
import com.example.fn.dto.cube.CubeReponse;
import com.fnproject.fn.api.FnFeature;
import com.fnproject.fn.api.Headers;
import com.fnproject.fn.api.flow.Flow;
import com.fnproject.fn.api.flow.FlowFuture;
import com.fnproject.fn.api.flow.Flows;
import com.fnproject.fn.api.flow.HttpMethod;
import com.fnproject.fn.runtime.flow.FlowFeature;
import com.example.fn.dto.carre.*;
import java.util.logging.Logger;




@FnFeature(FlowFeature.class)
public class HelloFunction {

    Logger logger = Logger.getLogger(HelloFunction.class.getName());

    public String handleRequest(String input) {
        Flow flow = Flows.currentFlow();


        CarreCommande carreCommand = new CarreCommande(Integer.valueOf(input));

        logger.info("Input: " + input);

        //FlowFuture<CarreReponse> carreBytesResponse = flow.invokeFunction("01D6JF4A7MNG8G00GZJ0000025",carreCommand,CarreReponse.class);

        return flow
                .invokeFunction(
                    "01D6JF4A7MNG8G00GZJ0000025",
                    HttpMethod.POST,
                    Headers.emptyHeaders(),
                    carreCommand,
                    CarreReponse.class)
                .thenApply(carreReponse -> {
                    return new CubeCommande(carreReponse.resultat);
                })
                .thenCompose(cubeCommande ->
                    flow.invokeFunction(
                            "01D6JH2QXVNG8G00GZJ0000032",
                            HttpMethod.POST,
                            Headers.emptyHeaders(),
                            cubeCommande,
                            CubeReponse.class)
                )
                .thenApply(cubeReponse -> ""+cubeReponse.resultat)
                .get();


        //String t = new String(carreBytesResponse.get());
        //logger.info("Carre: " + carreBytesResponse.get().resultat);

       // CubeCommande cubeCommande = new CubeCommande(carreBytesResponse.get().resultat);
        //FlowFuture<CubeReponse> cubeBytesResponse = flow.invokeFunction("01D6JH2QXVNG8G00GZJ0000032",cubeCommande,CubeReponse.class);



       // logger.info("Cube byte: " + byt);
       // String r = new String(byt);
       // logger.info("Cube: " + r);

        /*
        FlowFuture<byte[]> cubeBytesResponse = flow.invokeFunction("01D6JF4A7MNG8G00GZJ0000025",input)
                .thenApply(r -> r.getBodyAsBytes())
                .thenCompose(carreresponse ->
                    flow.invokeFunction("01D6JH2QXVNG8G00GZJ0000032",new String(carreresponse)
                ).thenApply(r -> r.getBodyAsBytes()));

/*
        byte[] cubeBytesResponse = flow.invokeFunction("01D6JH2QXVNG8G00GZJ0000032",new String(carreBytesResponse));

        //System.out.println("ok");
        // Get the first ten lines of the file
        FlowFuture<byte[]> headText = flow.invokeFunction( "./carre-flow", POST,
                emptyHeaders().setHeader("LINES", "10"), input )
                .thenApply(r -> {
                    HttpClient.HttpResponse res = new HttpClient.HttpResponse(r.getStatusCode());
                    byte[] t = null;

                    try {
                        t =  res.entityAsBytes();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return t;
                });*/

        // Grep for "love"
        /*FlowFuture<byte[]> wordCountResult =
                flow.invokeFunction( "./cube-flow", POST,
                        emptyHeaders().setHeader("WORD", "love"),
                        headText)
                        .thenApply(HttpResponse::getBodyAsBytes);*/



       // return new String(""+cubeBytesResponse.get().resultat);
        //return "Number of times I found 'love': " + headText + "\n" ;
    }
}