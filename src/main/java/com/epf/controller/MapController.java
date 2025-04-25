package com.epf.controller;

import com.epf.dto.MapDTO;
import com.epf.exception.ResourceNotFoundException;
import com.epf.model.Map;
import com.epf.service.MapService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/maps")
public class MapController {

    private static final Logger logger = LoggerFactory.getLogger(MapController.class);
    private final MapService mapService;

    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @GetMapping
    public ResponseEntity<List<MapDTO>> getAll() {
        logger.info("GET /maps - récupération de toutes les maps");
        List<MapDTO> maps = mapService.getAll().stream()
                .map(m -> new MapDTO(m.getIdMap(), m.getLigne(), m.getColonne(), m.getCheminImage()))
                .toList();
        return ResponseEntity.ok(maps);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MapDTO> getById(@PathVariable("id") int id) {
        logger.info("GET /maps/{}", id);
        Map map = mapService.getById(id)
                .orElseThrow(() -> {
                    logger.error("Map id={} non trouvée", id);
                    return new ResourceNotFoundException("Map avec l'id " + id + " non trouvée.");
                });

        MapDTO dto = new MapDTO(map.getIdMap(), map.getLigne(), map.getColonne(), map.getCheminImage());
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<Integer> insert(@RequestBody @Valid MapDTO mapDTO) {
        logger.info("POST /maps - insertion d'une map");
        Map map = new Map(0, mapDTO.getLigne(), mapDTO.getColonne(), mapDTO.getCheminImage());
        return ResponseEntity.ok(mapService.insert(map));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Integer> update(@PathVariable("id") int id, @RequestBody @Valid MapDTO mapDTO) {
        logger.info("PUT /maps/{} - mise à jour", id);
        Map map = new Map(id, mapDTO.getLigne(), mapDTO.getColonne(), mapDTO.getCheminImage());
        return ResponseEntity.ok(mapService.update(map));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") int id) {
        logger.warn("DELETE /maps/{} - suppression", id);
        return ResponseEntity.ok(mapService.delete(id));
    }
}
