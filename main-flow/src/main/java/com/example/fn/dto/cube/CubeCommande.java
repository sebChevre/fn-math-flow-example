package com.example.fn.dto.cube;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CubeCommande implements Serializable{

    public final Integer valeur;

    @JsonCreator
    public CubeCommande(@JsonProperty("valeur") Integer valeur){
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return "CubeCommande{" +
                "valeur=" + valeur +
                '}';
    }
}
