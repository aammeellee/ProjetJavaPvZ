package com.epf.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;

public class MapDTO {

    @JsonProperty("id_map")
    private int id;

    @Min(value = 1, message = "Le nombre de lignes doit être supérieur ou égal à 1.")
    private int ligne;

    @Min(value = 1, message = "Le nombre de colonnes doit être supérieur ou égal à 1.")
    private int colonne;

    @JsonProperty("chemin_image")
    private String cheminImage; 

    public MapDTO() {
    }

    public MapDTO(int id, int ligne, int colonne, String cheminImage) {
        this.id = id;
        this.ligne = ligne;
        this.colonne = colonne;
        this.cheminImage = cheminImage;
    }

    public int getId() { return id; }
    public int getLigne() { return ligne; }
    public int getColonne() { return colonne; }
    public String getCheminImage() { return cheminImage; }
}
