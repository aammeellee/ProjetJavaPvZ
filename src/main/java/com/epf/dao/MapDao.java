package com.epf.dao;

import com.epf.model.Map;
import java.util.List;
import java.util.Optional;

public interface MapDao {
    int insert(Map map);
    Optional<Map> getById(int id);
    List<Map> getAll();
    int update(Map map);
    int delete(int id);
}
