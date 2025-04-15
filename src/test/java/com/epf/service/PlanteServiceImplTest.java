package com.epf.service;

import com.epf.dao.PlanteDao;
import com.epf.model.Plante;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlanteServiceImplTest {

    @Mock
    private PlanteDao planteDao;

    @InjectMocks
    private PlanteServiceImpl planteService;

    @Test
    public void testInsert() {
        Plante plante = new Plante(0, "Laser Plant", 200, 2.0, 40, 300, 10.0, "normal", "images/plante/laser.png");

        when(planteDao.insert(plante)).thenReturn(1);

        assertEquals(1, planteService.insert(plante));
        verify(planteDao, times(1)).insert(plante);
    }

    @Test
    public void testGetById() {
        Plante plante = new Plante(1, "Tournesol", 100, 0.0, 0, 50, 25.0, "normal", "images/plante/tournesol.png");

        when(planteDao.getById(1)).thenReturn(Optional.of(plante));

        Optional<Plante> result = planteService.getById(1);
        assertTrue(result.isPresent());
        assertEquals("Tournesol", result.get().getNom());
    }

    @Test
    public void testGetAll() {
        when(planteDao.getAll()).thenReturn(Arrays.asList(
                new Plante(1, "A", 100, 1.0, 10, 50, 0.0, "normal", "imgA"),
                new Plante(2, "B", 120, 1.5, 20, 100, 0.0, "normal", "imgB")
        ));

        assertEquals(2, planteService.getAll().size());
    }

    @Test
    public void testUpdate() {
        Plante plante = new Plante(1, "Super Tournesol", 150, 1.0, 0, 75, 30.0, "normal", "img");

        when(planteDao.update(plante)).thenReturn(1);

        assertEquals(1, planteService.update(plante));
    }

    @Test
    public void testDelete() {
        when(planteDao.delete(1)).thenReturn(1);

        assertEquals(1, planteService.delete(1));
    }
}
