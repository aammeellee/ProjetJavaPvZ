package com.epf.service;

import com.epf.dao.MapDao;
import com.epf.model.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MapServiceImpl implements MapService {

    private static final Logger logger = LoggerFactory.getLogger(MapServiceImpl.class);
    private final MapDao mapDao;

    public MapServiceImpl(MapDao mapDao) {
        this.mapDao = mapDao;
    }

    @Override
    public int insert(Map map) {
        logger.info("Service - insertion de la map avec ligne={}, colonne={}", map.getLigne(), map.getColonne());
        return mapDao.insert(map);
    }

    @Override
    public Optional<Map> getById(int id) {
        logger.info("Service - récupération de la map avec id={}", id);
        return mapDao.getById(id);
    }

    @Override
    public List<Map> getAll() {
        logger.info("Service - récupération de toutes les maps");
        return mapDao.getAll();
    }

    @Override
    public int update(Map map) {
        logger.info("Service - mise à jour de la map id={}", map.getIdMap());
        return mapDao.update(map);
    }

    @Override
    public int delete(int id) {
        logger.warn("Service - suppression de la map id={}", id);
        return mapDao.delete(id);
    }
}
