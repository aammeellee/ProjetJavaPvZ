package com.epf.service;

import com.epf.model.Zombie;

import java.util.List;
import java.util.Optional;

public interface ZombieService {
    int insert(Zombie zombie);
    Optional<Zombie> getById(int id);
    List<Zombie> getAll();
    int update(Zombie zombie);
    int delete(int id);
    List<Zombie> getByMapId(int mapId); // bonus demandé dans le sujet
}
