package com.epf.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ZombieTest {

    @Test
    public void testConstructeurCompletEtGetters() {
        Zombie zombie = new Zombie(1, "Zombie Rapide", 150, 1.2, 25, 0.9, "images/zombie/rapide.png", 2);

        assertEquals(1, zombie.getIdZombie());
        assertEquals("Zombie Rapide", zombie.getNom());
        assertEquals(150, zombie.getPointDeVie());
        assertEquals(1.2, zombie.getAttaqueParSeconde());
        assertEquals(25, zombie.getDegatAttaque());
        assertEquals(0.9, zombie.getVitesseDeDeplacement());
        assertEquals("images/zombie/rapide.png", zombie.getCheminImage());
        assertEquals(2, zombie.getIdMap());
    }

    @Test
    public void testSetters() {
        Zombie zombie = new Zombie();

        zombie.setIdZombie(2);
        zombie.setNom("Zombie Tank");
        zombie.setPointDeVie(300);
        zombie.setAttaqueParSeconde(0.5);
        zombie.setDegatAttaque(50);
        zombie.setVitesseDeDeplacement(0.3);
        zombie.setCheminImage("images/zombie/tank.png");
        zombie.setIdMap(1);

        assertEquals(2, zombie.getIdZombie());
        assertEquals("Zombie Tank", zombie.getNom());
        assertEquals(300, zombie.getPointDeVie());
        assertEquals(0.5, zombie.getAttaqueParSeconde());
        assertEquals(50, zombie.getDegatAttaque());
        assertEquals(0.3, zombie.getVitesseDeDeplacement());
        assertEquals("images/zombie/tank.png", zombie.getCheminImage());
        assertEquals(1, zombie.getIdMap());
    }

    @Test
    public void testToString() {
        Zombie zombie = new Zombie(3, "Zombie Normal", 100, 0.8, 15, 0.5, "images/zombie/normal.png", 1);
        String attendu = "Zombie{idZombie=3, nom='Zombie Normal', pointDeVie=100, attaqueParSeconde=0.8, degatAttaque=15, vitesseDeDeplacement=0.5, cheminImage='images/zombie/normal.png', idMap=1}";
        assertEquals(attendu, zombie.toString());
    }
}
