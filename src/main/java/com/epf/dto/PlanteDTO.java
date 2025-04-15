package com.epf.dto;

public class PlanteDTO {
    private int id;
    private String nom;
    private int pointDeVie;
    private double attaqueParSeconde;
    private int degatAttaque;
    private int cout;
    private double soleilParSeconde;
    private String effet;
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
