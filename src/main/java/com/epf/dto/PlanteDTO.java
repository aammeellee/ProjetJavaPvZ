package com.epf.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public class PlanteDTO {

    @JsonProperty("id_plante")
    private int id;

    @NotBlank(message = "Le nom de la plante est obligatoire.")
    private String nom;

    @Min(value = 0, message = "Le point de vie ne peut pas être négatif.")
    @JsonProperty("point_de_vie")
    private int pointDeVie;

    @PositiveOrZero(message = "L'attaque par seconde ne peut pas être négative.")
    @JsonProperty("attaque_par_seconde")
    private double attaqueParSeconde;

    @PositiveOrZero(message = "Le dégât d'attaque ne peut pas être négatif.")
    @JsonProperty("degat_attaque")
    private int degatAttaque;

    @PositiveOrZero(message = "Le coût ne peut pas être négatif.")
    private int cout;

    @PositiveOrZero(message = "Le soleil par seconde ne peut pas être négatif.")
    @JsonProperty("soleil_par_seconde")
    private double soleilParSeconde;

    private String effet;

    @JsonProperty("chemin_image")
    private String cheminImage; // Peut être null sur PUT

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
