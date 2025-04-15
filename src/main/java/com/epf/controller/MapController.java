package com.epf.controller;

import com.epf.dto.MapDTO;
import com.epf.model.Map;
import com.epf.service.MapService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/maps")
public class MapController {

    private final MapService mapService;

    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @GetMapping
    public ResponseEntity<List<MapDTO>> getAll() {
        List<MapDTO> maps = mapService.getAll().stream()
                .map(m -> new MapDTO(m.getIdMap(), m.getLigne(), m.getColonne(), m.getCheminImage()))
                .toList();

        return ResponseEntity.ok(maps);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MapDTO> getById(@PathVariable("id") int id) {
        Optional<Map> map = mapService.getById(id);
        return map.map(m -> ResponseEntity.ok(new MapDTO(m.getIdMap(), m.getLigne(), m.getColonne(), m.getCheminImage())))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Integer> insert(@RequestBody @Valid MapDTO mapDTO) {
        Map map = new Map(0, mapDTO.getLigne(), mapDTO.getColonne(), mapDTO.getCheminImage());
        int result = mapService.insert(map);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Integer> update(@PathVariable("id") int id, @RequestBody @Valid MapDTO mapDTO) {
        Map map = new Map(id, mapDTO.getLigne(), mapDTO.getColonne(), mapDTO.getCheminImage());
        int result = mapService.update(map);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") int id) {
        int result = mapService.delete(id);
        return ResponseEntity.ok(result);
    }
}
