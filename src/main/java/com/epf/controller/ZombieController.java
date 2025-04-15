package com.epf.controller;

import com.epf.dto.ZombieDTO;
import com.epf.model.Zombie;
import com.epf.service.ZombieService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/zombies")
public class ZombieController {

    private final ZombieService zombieService;

    public ZombieController(ZombieService zombieService) {
        this.zombieService = zombieService;
    }

    @GetMapping
    public ResponseEntity<List<ZombieDTO>> getAll() {
        List<ZombieDTO> zombies = zombieService.getAll().stream()
                .map(z -> new ZombieDTO(
                        z.getIdZombie(), z.getNom(), z.getPointDeVie(),
                        z.getAttaqueParSeconde(), z.getDegatAttaque(),
                        z.getVitesseDeDeplacement(), z.getCheminImage(), z.getIdMap()
                ))
                .toList();

        return ResponseEntity.ok(zombies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ZombieDTO> getById(@PathVariable("id") int id) {
        Optional<Zombie> zombie = zombieService.getById(id);
        return zombie.map(z -> ResponseEntity.ok(new ZombieDTO(
                z.getIdZombie(), z.getNom(), z.getPointDeVie(),
                z.getAttaqueParSeconde(), z.getDegatAttaque(),
                z.getVitesseDeDeplacement(), z.getCheminImage(), z.getIdMap()
        ))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Integer> insert(@RequestBody @Valid ZombieDTO dto) {
        Zombie zombie = new Zombie(0, dto.getNom(), dto.getPointDeVie(),
                dto.getAttaqueParSeconde(), dto.getDegatAttaque(),
                dto.getVitesseDeDeplacement(), dto.getCheminImage(), dto.getIdMap());
        return ResponseEntity.ok(zombieService.insert(zombie));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Integer> update(@PathVariable("id") int id, @RequestBody @Valid ZombieDTO dto) {
        Zombie zombie = new Zombie(id, dto.getNom(), dto.getPointDeVie(),
                dto.getAttaqueParSeconde(), dto.getDegatAttaque(),
                dto.getVitesseDeDeplacement(), dto.getCheminImage(), dto.getIdMap());
        return ResponseEntity.ok(zombieService.update(zombie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") int id) {
        return ResponseEntity.ok(zombieService.delete(id));
    }

    @GetMapping("/map/{mapId}")
    public ResponseEntity<List<ZombieDTO>> getByMapId(@PathVariable("mapId") int mapId) {
        List<ZombieDTO> zombies = zombieService.getByMapId(mapId).stream()
                .map(z -> new ZombieDTO(
                        z.getIdZombie(), z.getNom(), z.getPointDeVie(),
                        z.getAttaqueParSeconde(), z.getDegatAttaque(),
                        z.getVitesseDeDeplacement(), z.getCheminImage(), z.getIdMap()
                ))
                .toList();

        return ResponseEntity.ok(zombies);
    }
}
