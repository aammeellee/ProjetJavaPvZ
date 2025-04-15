package com.epf.dto;

public class MapDTO {
    private int id;
    private int ligne;
    private int colonne;
    private String cheminImage;

    public MapDTO() {
    }

    public MapDTO(int id, int ligne, int colonne, String cheminImage) {
        this.id = id;
        this.ligne = ligne;
        this.colonne = colonne;
        this.cheminImage = cheminImage;
    }

    public int getId() {
        return id;
    }

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public String getCheminImage() {
        return cheminImage;
    }
}
