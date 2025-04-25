package com.epf.controller;

import com.epf.model.Zombie;
import com.epf.service.ZombieService;
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

public class ZombieControllerTest {

    private MockMvc mockMvc;
    private ZombieService zombieService;

    @BeforeEach
    void setUp() {
        zombieService = Mockito.mock(ZombieService.class);
        ZombieController controller = new ZombieController(zombieService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testGetAllZombies() throws Exception {
        when(zombieService.getAll()).thenReturn(List.of(
                new Zombie(1, "Zombie de base", 100, 1.0, 20, 0.5, "img/zombie.png", 1)
        ));

        mockMvc.perform(get("/zombies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].nom").value("Zombie de base"));
    }

    @Test
    void testGetZombieById() throws Exception {
        when(zombieService.getById(1)).thenReturn(Optional.of(
                new Zombie(1, "Zombie cône", 200, 1.0, 30, 0.6, "img/cone.png", 2)
        ));

        mockMvc.perform(get("/zombies/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.point_de_vie").value(200))
                .andExpect(jsonPath("$.chemin_image").value("img/cone.png"));
    }

    @Test
    void testGetZombiesByMapId() throws Exception {
        when(zombieService.getByMapId(2)).thenReturn(List.of(
                new Zombie(2, "Zombie cône", 200, 1.0, 30, 0.6, "img/cone.png", 2)
        ));

        mockMvc.perform(get("/zombies/map/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id_map").value(2));
    }

    @Test
    void testCreateZombie() throws Exception {
        when(zombieService.insert(any(Zombie.class))).thenReturn(1);

        String json = """
                {
                    "nom": "Zombie cône",
                    "point_de_vie": 200,
                    "attaque_par_seconde": 1.0,
                    "degat_attaque": 30,
                    "vitesse_de_deplacement": 0.6,
                    "chemin_image": "img/cone.png",
                    "id_map": 2
                }
                """;

        mockMvc.perform(post("/zombies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    void testUpdateZombie() throws Exception {
        when(zombieService.update(any(Zombie.class))).thenReturn(1);

        String json = """
                {
                    "nom": "Zombie cône renforcé",
                    "point_de_vie": 250,
                    "attaque_par_seconde": 1.2,
                    "degat_attaque": 35,
                    "vitesse_de_deplacement": 0.5,
                    "chemin_image": "img/cone_strong.png",
                    "id_map": 2
                }
                """;

        mockMvc.perform(put("/zombies/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    void testDeleteZombie() throws Exception {
        when(zombieService.delete(eq(1))).thenReturn(1);

        mockMvc.perform(delete("/zombies/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }
}
