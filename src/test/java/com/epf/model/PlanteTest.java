package com.epf.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlanteTest {

    @Test
    public void testConstructeurCompletEtGetters() {
        Plante plante = new Plante(1, "Tournesol", 100, 0.0, 0, 50, 25.0, "normal", "images/plante/tournesol.png");

        assertEquals(1, plante.getIdPlante());
        assertEquals("Tournesol", plante.getNom());
        assertEquals(100, plante.getPointDeVie());
        assertEquals(0.0, plante.getAttaqueParSeconde());
        assertEquals(0, plante.getDegatAttaque());
        assertEquals(50, plante.getCout());
        assertEquals(25.0, plante.getSoleilParSeconde());
        assertEquals("normal", plante.getEffet());
        assertEquals("images/plante/tournesol.png", plante.getCheminImage());
    }

    @Test
    public void testSetters() {
        Plante plante = new Plante();

        plante.setIdPlante(2);
        plante.setNom("Noix");
        plante.setPointDeVie(300);
        plante.setAttaqueParSeconde(0.0);
        plante.setDegatAttaque(0);
        plante.setCout(50);
        plante.setSoleilParSeconde(0.0);
        plante.setEffet("normal");
        plante.setCheminImage("images/plante/noix.png");

        assertEquals(2, plante.getIdPlante());
        assertEquals("Noix", plante.getNom());
        assertEquals(300, plante.getPointDeVie());
        assertEquals(0.0, plante.getAttaqueParSeconde());
        assertEquals(0, plante.getDegatAttaque());
        assertEquals(50, plante.getCout());
        assertEquals(0.0, plante.getSoleilParSeconde());
        assertEquals("normal", plante.getEffet());
        assertEquals("images/plante/noix.png", plante.getCheminImage());
    }

    @Test
    public void testToString() {
        Plante plante = new Plante(3, "Glace Pois", 120, 1.0, 10, 175, 0.0, "slow low", "images/plante/glacepois.png");

        String attendu = "Plante{idPlante=3, nom='Glace Pois', pointDeVie=120, attaqueParSeconde=1.0, degatAttaque=10, cout=175, soleilParSeconde=0.0, effet='slow low', cheminImage='images/plante/glacepois.png'}";

        assertEquals(attendu, plante.toString());
    }
}
