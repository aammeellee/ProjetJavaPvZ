package com.epf.controller;

import com.epf.dto.PlanteDTO;
import com.epf.model.Plante;
import com.epf.service.PlanteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/plantes")
public class PlanteController {

    private final PlanteService planteService;

    public PlanteController(PlanteService planteService) {
        this.planteService = planteService;
    }

    @GetMapping
    public ResponseEntity<List<PlanteDTO>> getAll() {
        List<PlanteDTO> plantes = planteService.getAll().stream()
                .map(p -> new PlanteDTO(
                        p.getIdPlante(), p.getNom(), p.getPointDeVie(),
                        p.getAttaqueParSeconde(), p.getDegatAttaque(),
                        p.getCout(), p.getSoleilParSeconde(), p.getEffet(), p.getCheminImage()
                ))
                .toList();

        return ResponseEntity.ok(plantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanteDTO> getById(@PathVariable("id") int id) {
        Optional<Plante> plante = planteService.getById(id);
        return plante.map(p -> ResponseEntity.ok(new PlanteDTO(
                p.getIdPlante(), p.getNom(), p.getPointDeVie(),
                p.getAttaqueParSeconde(), p.getDegatAttaque(),
                p.getCout(), p.getSoleilParSeconde(), p.getEffet(), p.getCheminImage()
        ))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Integer> insert(@RequestBody @Valid PlanteDTO dto) {
        Plante plante = new Plante(0, dto.getNom(), dto.getPointDeVie(),
                dto.getAttaqueParSeconde(), dto.getDegatAttaque(),
                dto.getCout(), dto.getSoleilParSeconde(), dto.getEffet(), dto.getCheminImage());
        return ResponseEntity.ok(planteService.insert(plante));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Integer> update(@PathVariable("id") int id, @RequestBody @Valid PlanteDTO dto) {
        Plante plante = new Plante(id, dto.getNom(), dto.getPointDeVie(),
                dto.getAttaqueParSeconde(), dto.getDegatAttaque(),
                dto.getCout(), dto.getSoleilParSeconde(), dto.getEffet(), dto.getCheminImage());
        return ResponseEntity.ok(planteService.update(plante));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") int id) {
        return ResponseEntity.ok(planteService.delete(id));
    }
}
