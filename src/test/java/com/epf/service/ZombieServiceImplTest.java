package com.epf.service;

import com.epf.dao.ZombieDao;
import com.epf.model.Zombie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ZombieServiceImplTest {

    @Mock
    private ZombieDao zombieDao;

    @InjectMocks
    private ZombieServiceImpl zombieService;

    @Test
    public void testInsert() {
        Zombie zombie = new Zombie(0, "Zombie Lourd", 300, 0.5, 20, 0.3, "images/zombie/lourd.png", 1);

        when(zombieDao.insert(zombie)).thenReturn(1);

        assertEquals(1, zombieService.insert(zombie));
        verify(zombieDao, times(1)).insert(zombie);
    }

    @Test
    public void testGetById() {
        Zombie zombie = new Zombie(1, "Runner", 100, 1.5, 15, 1.0, "images/zombie/runner.png", 1);

        when(zombieDao.getById(1)).thenReturn(Optional.of(zombie));

        Optional<Zombie> result = zombieService.getById(1);
        assertTrue(result.isPresent());
        assertEquals("Runner", result.get().getNom());
    }

    @Test
    public void testGetAll() {
        when(zombieDao.getAll()).thenReturn(Arrays.asList(
                new Zombie(1, "A", 100, 1.0, 10, 0.5, "imgA", 1),
                new Zombie(2, "B", 120, 1.2, 12, 0.6, "imgB", 1)
        ));

        List<Zombie> result = zombieService.getAll();
        assertEquals(2, result.size());
    }

    @Test
    public void testUpdate() {
        Zombie zombie = new Zombie(1, "Z", 150, 1.1, 18, 0.4, "imgZ", 1);

        when(zombieDao.update(zombie)).thenReturn(1);

        assertEquals(1, zombieService.update(zombie));
    }

    @Test
    public void testDelete() {
        when(zombieDao.delete(1)).thenReturn(1);

        assertEquals(1, zombieService.delete(1));
    }

    @Test
    public void testGetByMapId() {
        when(zombieDao.getByMapId(1)).thenReturn(Arrays.asList(
                new Zombie(1, "Conehead", 200, 0.8, 10, 0.5, "img", 1)
        ));

        List<Zombie> result = zombieService.getByMapId(1);
        assertEquals(1, result.size());
        assertEquals("Conehead", result.get(0).getNom());
    }
}
