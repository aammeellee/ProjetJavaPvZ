package com.epf.service;

import com.epf.dao.MapDao;
import com.epf.model.Map;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MapServiceImpl implements MapService {

    private final MapDao mapDao;

    public MapServiceImpl(MapDao mapDao) {
        this.mapDao = mapDao;
    }

    @Override
    public int insert(Map map) {
        return mapDao.insert(map);
    }

    @Override
    public Optional<Map> getById(int id) {
        return mapDao.getById(id);
    }

    @Override
    public List<Map> getAll() {
        return mapDao.getAll();
    }

    @Override
    public int update(Map map) {
        return mapDao.update(map);
    }

    @Override
    public int delete(int id) {
        return mapDao.delete(id);
    }
}
