package com.epf.dao;

import com.epf.model.Plante;

import java.util.List;
import java.util.Optional;

public interface PlanteDao {
    int insert(Plante plante);
    Optional<Plante> getById(int id);
    List<Plante> getAll();
    int update(Plante plante);
    int delete(int id);
}
