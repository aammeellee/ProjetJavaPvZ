package com.epf.controller;

import com.epf.model.Plante;
import com.epf.service.PlanteService;
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

public class PlanteControllerTest {

    private MockMvc mockMvc;
    private PlanteService planteService;

    @BeforeEach
    void setUp() {
        planteService = Mockito.mock(PlanteService.class);
        PlanteController controller = new PlanteController(planteService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testGetAllPlantes() throws Exception {
        when(planteService.getAll()).thenReturn(List.of(
                new Plante(1, "Tournesol", 100, 0, 0, 50, 25, "donne du soleil", "img/tournesol.png")
        ));

        mockMvc.perform(get("/plantes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].nom").value("Tournesol"));
    }

    @Test
    void testGetPlanteById() throws Exception {
        when(planteService.getById(1)).thenReturn(Optional.of(
                new Plante(1, "Pisto-pois", 100, 1.5, 20, 100, 0, "tire des pois", "img/pois.png")
        ));

        mockMvc.perform(get("/plantes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("Pisto-pois"));
    }

    @Test
    void testCreatePlante() throws Exception {
        when(planteService.insert(any(Plante.class))).thenReturn(1);

        String json = """
                {
                    "nom": "Noix",
                    "point_de_vie": 300,
                    "attaque_par_seconde": 0,
                    "degat_attaque": 0,
                    "cout": 50,
                    "soleil_par_seconde": 0,
                    "effet": "bloque les zombies",
                    "chemin_image": "img/noix.png"
                }
                """;

        mockMvc.perform(post("/plantes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    void testUpdatePlante() throws Exception {
        when(planteService.update(any(Plante.class))).thenReturn(1);

        String json = """
                {
                    "nom": "Noix améliorée",
                    "point_de_vie": 400,
                    "attaque_par_seconde": 0,
                    "degat_attaque": 0,
                    "cout": 75,
                    "soleil_par_seconde": 0,
                    "effet": "bloque + longtemps",
                    "chemin_image": "img/noix_plus.png"
                }
                """;

        mockMvc.perform(put("/plantes/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    void testDeletePlante() throws Exception {
        when(planteService.delete(eq(1))).thenReturn(1);

        mockMvc.perform(delete("/plantes/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }
}
