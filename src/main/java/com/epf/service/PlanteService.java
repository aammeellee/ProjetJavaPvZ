package com.epf.service;

import com.epf.model.Plante;

import java.util.List;
import java.util.Optional;

public interface PlanteService {
    int insert(Plante plante);
    Optional<Plante> getById(int id);
    List<Plante> getAll();
    int update(Plante plante);
    int delete(int id);
}
