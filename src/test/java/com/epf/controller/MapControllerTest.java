package com.epf.controller;

import com.epf.model.Map;
import com.epf.service.MapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class MapControllerTest {

    private MockMvc mockMvc;
    private MapService mapService;

    @BeforeEach
    void setUp() {
        mapService = Mockito.mock(MapService.class);
        MapController controller = new MapController(mapService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testGetAllMaps() throws Exception {
        when(mapService.getAll()).thenReturn(List.of(
                new Map(1, 5, 9, "img/map1.png")
        ));

        mockMvc.perform(get("/maps"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].chemin_image").value("img/map1.png"));
    }

    @Test
    void testGetMapById() throws Exception {
        when(mapService.getById(1)).thenReturn(Optional.of(
                new Map(1, 6, 9, "img/map2.png")
        ));

        mockMvc.perform(get("/maps/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ligne").value(6))
                .andExpect(jsonPath("$.colonne").value(9));
    }

    @Test
    void testCreateMap() throws Exception {
        when(mapService.insert(any(Map.class))).thenReturn(1);

        String json = """
                {
                    "ligne": 5,
                    "colonne": 9,
                    "chemin_image": "img/map1.png"
                }
                """;

        mockMvc.perform(post("/maps")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    void testUpdateMap() throws Exception {
        when(mapService.update(any(Map.class))).thenReturn(1);

        String json = """
                {
                    "ligne": 6,
                    "colonne": 10,
                    "chemin_image": "img/map1_update.png"
                }
                """;

        mockMvc.perform(put("/maps/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    void testDeleteMap() throws Exception {
        when(mapService.delete(eq(1))).thenReturn(1);

        mockMvc.perform(delete("/maps/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }
}
