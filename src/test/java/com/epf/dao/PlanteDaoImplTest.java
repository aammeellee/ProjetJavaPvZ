package com.epf.dao;

import com.epf.config.DataSourceTestConfig;
import com.epf.model.Plante;
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
@ContextConfiguration(classes = {PlanteDaoImpl.class, DataSourceTestConfig.class})
@Transactional
public class PlanteDaoImplTest {

    @Autowired
    private PlanteDaoImpl planteDao;

    @Test
    public void testInsertGetUpdateDelete() {
        Plante plante = new Plante(0, "Plante Laser", 200, 2.5, 40, 300, 10.0, "normal", "images/plante/laser.png");

        // INSERT
        int inserted = planteDao.insert(plante);
        assertEquals(1, inserted);

        List<Plante> plantes = planteDao.getAll();
        assertFalse(plantes.isEmpty());
        Plante dernierePlante = plantes.get(plantes.size() - 1);
        int idCree = dernierePlante.getIdPlante();

        // GET
        Optional<Plante> recup = planteDao.getById(idCree);
        assertTrue(recup.isPresent());
        assertEquals("Plante Laser", recup.get().getNom());

        // UPDATE
        Plante planteMaj = new Plante(idCree, "Mega Plante Laser", 250, 3.0, 50, 350, 20.0, "slow low", "images/plante/megalaser.png");
        int updated = planteDao.update(planteMaj);
        assertEquals(1, updated);

        Optional<Plante> recupMaj = planteDao.getById(idCree);
        assertTrue(recupMaj.isPresent());
        assertEquals("Mega Plante Laser", recupMaj.get().getNom());

        // DELETE
        int deleted = planteDao.delete(idCree);
        assertEquals(1, deleted);

        Optional<Plante> recupDelete = planteDao.getById(idCree);
        assertFalse(recupDelete.isPresent());
    }
}
