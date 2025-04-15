package com.epf.dao;

import com.epf.config.DataSourceTestConfig;
import com.epf.model.Zombie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ZombieDaoImpl.class, DataSourceTestConfig.class})
@Transactional
public class ZombieDaoImplTest {

    @Autowired
    private ZombieDaoImpl zombieDao;

    @Test
    public void testInsertGetUpdateDelete() {
        Zombie zombie = new Zombie(0, "Zombie Speed", 80, 1.5, 15, 1.2, "images/zombie/speed.png", 1);

        // INSERT
        int inserted = zombieDao.insert(zombie);
        assertEquals(1, inserted);

        List<Zombie> zombies = zombieDao.getAll();
        assertFalse(zombies.isEmpty());
        Zombie dernierZombie = zombies.get(zombies.size() - 1);
        int idCree = dernierZombie.getIdZombie();

        // GET
        Optional<Zombie> recup = zombieDao.getById(idCree);
        assertTrue(recup.isPresent());
        assertEquals("Zombie Speed", recup.get().getNom());

        // UPDATE
        Zombie zombieMaj = new Zombie(idCree, "Zombie Ultra Speed", 100, 2.0, 20, 1.5, "images/zombie/ultraspeed.png", 2);
        int updated = zombieDao.update(zombieMaj);
        assertEquals(1, updated);

        Optional<Zombie> recupMaj = zombieDao.getById(idCree);
        assertTrue(recupMaj.isPresent());
        assertEquals("Zombie Ultra Speed", recupMaj.get().getNom());

        // DELETE
        int deleted = zombieDao.delete(idCree);
        assertEquals(1, deleted);

        Optional<Zombie> recupDelete = zombieDao.getById(idCree);
        assertFalse(recupDelete.isPresent());
    }

    @Test
    public void testGetByMapId() {
        // La map 1 est utilisée dans le fichier data.sql pour plusieurs zombies
        List<Zombie> zombies = zombieDao.getByMapId(1);

        assertNotNull(zombies);
        assertFalse(zombies.isEmpty());

        // On peut tester que chaque zombie retourné a bien l'id_map = 1
        for (Zombie z : zombies) {
            assertEquals(1, z.getIdMap());
        }
    }

}
