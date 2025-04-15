package com.epf.dao;

import com.epf.config.DataSourceTestConfig;
import com.epf.model.Map;
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
@ContextConfiguration(classes = {MapDaoImpl.class, DataSourceTestConfig.class})
@Transactional
public class MapDaoImplTest {

    @Autowired
    private MapDaoImpl mapDao;

    @Test
    public void testInsertGetUpdateDelete() {
        Map map = new Map(0, 5, 7, "images/map/test.png");

        int inserted = mapDao.insert(map);
        assertEquals(1, inserted);

        List<Map> maps = mapDao.getAll();
        assertFalse(maps.isEmpty());
        Map dernierMap = maps.get(maps.size() - 1);
        int idCree = dernierMap.getIdMap();

        Optional<Map> recup = mapDao.getById(idCree);
        assertTrue(recup.isPresent());
        assertEquals(5, recup.get().getLigne());

        Map mapMaj = new Map(idCree, 9, 9, "images/map/maj.png");
        int updated = mapDao.update(mapMaj);
        assertEquals(1, updated);

        Optional<Map> recupMaj = mapDao.getById(idCree);
        assertTrue(recupMaj.isPresent());
        assertEquals(9, recupMaj.get().getLigne());

        int deleted = mapDao.delete(idCree);
        assertEquals(1, deleted);

        Optional<Map> recupDelete = mapDao.getById(idCree);
        assertFalse(recupDelete.isPresent());
    }
}
