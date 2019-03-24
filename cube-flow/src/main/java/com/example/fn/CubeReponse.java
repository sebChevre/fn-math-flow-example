package com.example.fn;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CubeReponse implements Serializable{

    public final Integer resultat;

    @JsonCreator
    public CubeReponse(@JsonProperty("resultat") Integer resultat){
        this.resultat = resultat;
    }

    @Override
    public String toString() {
        return "CubeReponse{" +
                "resultat=" + resultat +
                '}';
    }
}
