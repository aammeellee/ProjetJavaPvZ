package com.epf.service;

import com.epf.dao.MapDao;
import com.epf.model.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MapServiceImplTest {

    @Mock
    private MapDao mapDao;

    @InjectMocks
    private MapServiceImpl mapService;

    @Test
    public void testInsert() {
        Map map = new Map(0, 5, 7, "images/map/test.png");

        when(mapDao.insert(map)).thenReturn(1);

        int result = mapService.insert(map);
        assertEquals(1, result);

        verify(mapDao, times(1)).insert(map);
    }

    @Test
    public void testGetById() {
        Map map = new Map(1, 5, 7, "images/map/test.png");

        when(mapDao.getById(1)).thenReturn(Optional.of(map));

        Optional<Map> result = mapService.getById(1);
        assertTrue(result.isPresent());
        assertEquals(5, result.get().getLigne());
    }

    @Test
    public void testGetAll() {
        when(mapDao.getAll()).thenReturn(Arrays.asList(
                new Map(1, 5, 7, "img1"),
                new Map(2, 6, 9, "img2")
        ));

        assertEquals(2, mapService.getAll().size());
    }

    @Test
    public void testUpdate() {
        Map map = new Map(1, 9, 9, "images/map/maj.png");

        when(mapDao.update(map)).thenReturn(1);

        int result = mapService.update(map);
        assertEquals(1, result);
    }

    @Test
    public void testDelete() {
        when(mapDao.delete(1)).thenReturn(1);

        int result = mapService.delete(1);
        assertEquals(1, result);
    }
}
