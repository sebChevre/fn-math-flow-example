package com.example.fn;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CarreCommande implements Serializable{

    public final Integer valeur;

    @JsonCreator
    public CarreCommande(@JsonProperty("valeur") Integer valeur){
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return "CarreCommande{" +
                "valeur=" + valeur +
                '}';
    }
}
