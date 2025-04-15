package com.epf.service;

import com.epf.model.Map;

import java.util.List;
import java.util.Optional;

public interface MapService {
    int insert(Map map);
    Optional<Map> getById(int id);
    List<Map> getAll();
    int update(Map map);
    int delete(int id);
}
