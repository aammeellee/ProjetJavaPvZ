// 🔹 ZombieController.java
package com.epf.controller;

import com.epf.dto.ZombieDTO;
import com.epf.exception.ResourceNotFoundException;
import com.epf.model.Zombie;
import com.epf.service.ZombieService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zombies")
public class ZombieController {

    private static final Logger logger = LoggerFactory.getLogger(ZombieController.class);
    private final ZombieService zombieService;

    public ZombieController(ZombieService zombieService) {
        this.zombieService = zombieService;
    }

    @GetMapping
    public ResponseEntity<List<ZombieDTO>> getAll() {
        logger.info("GET /zombies - récupération de tous les zombies");
        List<ZombieDTO> zombies = zombieService.getAll().stream()
                .map(z -> new ZombieDTO(z.getIdZombie(), z.getNom(), z.getPointDeVie(), z.getAttaqueParSeconde(),
                        z.getDegatAttaque(), z.getVitesseDeDeplacement(), z.getCheminImage(), z.getIdMap()))
                .toList();
        return ResponseEntity.ok(zombies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ZombieDTO> getById(@PathVariable("id") int id) {
        logger.info("GET /zombies/{}", id);
        Zombie z = zombieService.getById(id)
                .orElseThrow(() -> {
                    logger.error("Zombie id={} non trouvé", id);
                    return new ResourceNotFoundException("Zombie avec l'id " + id + " non trouvé.");
                });

        ZombieDTO dto = new ZombieDTO(z.getIdZombie(), z.getNom(), z.getPointDeVie(), z.getAttaqueParSeconde(),
                z.getDegatAttaque(), z.getVitesseDeDeplacement(), z.getCheminImage(), z.getIdMap());
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<Integer> insert(@RequestBody @Valid ZombieDTO dto) {
        logger.info("POST /zombies - insertion du zombie {}", dto.getNom());
        Zombie z = new Zombie(0, dto.getNom(), dto.getPointDeVie(), dto.getAttaqueParSeconde(), dto.getDegatAttaque(),
                dto.getVitesseDeDeplacement(), dto.getCheminImage(), dto.getIdMap());
        return ResponseEntity.ok(zombieService.insert(z));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Integer> update(@PathVariable("id") int id, @RequestBody @Valid ZombieDTO dto) {
        logger.info("PUT /zombies/{} - mise à jour du zombie {}", id, dto.getNom());
        Zombie z = new Zombie(id, dto.getNom(), dto.getPointDeVie(), dto.getAttaqueParSeconde(), dto.getDegatAttaque(),
                dto.getVitesseDeDeplacement(), dto.getCheminImage(), dto.getIdMap());
        return ResponseEntity.ok(zombieService.update(z));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") int id) {
        logger.warn("DELETE /zombies/{} - suppression", id);
        return ResponseEntity.ok(zombieService.delete(id));
    }

    @GetMapping("/map/{mapId}")
    public ResponseEntity<List<ZombieDTO>> getZombiesByMapId(@PathVariable("mapId") int mapId) {
        logger.info("GET /zombies/map/{} - récupération des zombies pour la map", mapId);
        List<ZombieDTO> zombies = zombieService.getByMapId(mapId).stream()
                .map(z -> new ZombieDTO(z.getIdZombie(), z.getNom(), z.getPointDeVie(), z.getAttaqueParSeconde(),
                        z.getDegatAttaque(), z.getVitesseDeDeplacement(), z.getCheminImage(), z.getIdMap()))
                .toList();
        return ResponseEntity.ok(zombies);
    }
}