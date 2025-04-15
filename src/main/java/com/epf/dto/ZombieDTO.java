package com.epf.dto;

public class ZombieDTO {
    private int id;
    private String nom;
    private int pointDeVie;
    private double attaqueParSeconde;
    private int degatAttaque;
    private double vitesseDeDeplacement;
    private String cheminImage;
    private int idMap;

    public ZombieDTO() {
    }

    public ZombieDTO(int id, String nom, int pointDeVie, double attaqueParSeconde, int degatAttaque,
                     double vitesseDeDeplacement, String cheminImage, int idMap) {
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
    public int getIdMap() { return idMap; }
}
