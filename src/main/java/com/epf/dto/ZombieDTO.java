package com.epf.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ZombieDTO {

    @JsonProperty("id_zombie")
    private int id;

    private String nom;

    @JsonProperty("point_de_vie")
    private int pointDeVie;

    @JsonProperty("attaque_par_seconde")
    private double attaqueParSeconde;

    @JsonProperty("degat_attaque")
    private int degatAttaque;

    @JsonProperty("vitesse_de_deplacement")
    private double vitesseDeDeplacement;

    @JsonProperty("chemin_image")
    private String cheminImage;

    @JsonProperty("id_map")
    private Integer idMap;

    public ZombieDTO() {
    }

    public ZombieDTO(int id, String nom, int pointDeVie, double attaqueParSeconde, int degatAttaque,
                     double vitesseDeDeplacement, String cheminImage, Integer idMap) {
        this.id = id;
        this.nom = nom;
        this.pointDeVie = pointDeVie;
        this.attaqueParSeconde = attaqueParSeconde;
        this.degatAttaque = degatAttaque;
        this.vitesseDeDeplacement = vitesseDeDeplacement;
        this.cheminImage = cheminImage;
        this.idMap = idMap;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public int getPointDeVie() { return pointDeVie; }
    public double getAttaqueParSeconde() { return attaqueParSeconde; }
    public int getDegatAttaque() { return degatAttaque; }
    public double getVitesseDeDeplacement() { return vitesseDeDeplacement; }
    public String getCheminImage() { return cheminImage; }
    public Integer getIdMap() { return idMap; }
}
