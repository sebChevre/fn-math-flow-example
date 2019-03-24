package com.example.fn.dto.carre;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CarreReponse implements Serializable{

    public final Integer resultat;

    @JsonCreator
    public CarreReponse(@JsonProperty("resultat") Integer resultat){
        this.resultat = resultat;
    }

    @Override
    public String toString() {
        return "CarreReponse{" +
                "resultat=" + resultat +
                '}';
    }
}
