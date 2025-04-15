package com.epf.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlanteDTO {

    @JsonProperty("id_plante")
    private int id;

    private String nom;

    @JsonProperty("point_de_vie")
    private int pointDeVie;

    @JsonProperty("attaque_par_seconde")
    private double attaqueParSeconde;

    @JsonProperty("degat_attaque")
    private int degatAttaque;

    private int cout;

    @JsonProperty("soleil_par_seconde")
    private double soleilParSeconde;

    private String effet;

    @JsonProperty("chemin_image")
    private String cheminImage;

    public PlanteDTO() {
    }

    public PlanteDTO(int id, String nom, int pointDeVie, double attaqueParSeconde, int degatAttaque,
                     int cout, double soleilParSeconde, String effet, String cheminImage) {
        this.id = id;
        this.nom = nom;
        this.pointDeVie = pointDeVie;
        this.attaqueParSeconde = attaqueParSeconde;
        this.degatAttaque = degatAttaque;
        this.cout = cout;
        this.soleilParSeconde = soleilParSeconde;
        this.effet = effet;
        this.cheminImage = cheminImage;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public int getPointDeVie() { return pointDeVie; }
    public double getAttaqueParSeconde() { return attaqueParSeconde; }
    public int getDegatAttaque() { return degatAttaque; }
    public int getCout() { return cout; }
    public double getSoleilParSeconde() { return soleilParSeconde; }
    public String getEffet() { return effet; }
    public String getCheminImage() { return cheminImage; }
}
