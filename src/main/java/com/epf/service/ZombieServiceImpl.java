package com.epf.service;

import com.epf.dao.ZombieDao;
import com.epf.model.Zombie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZombieServiceImpl implements ZombieService {

    private static final Logger logger = LoggerFactory.getLogger(ZombieServiceImpl.class);
    private final ZombieDao zombieDao;

    public ZombieServiceImpl(ZombieDao zombieDao) {
        this.zombieDao = zombieDao;
    }

    @Override
    public int insert(Zombie zombie) {
        logger.info("Service - insertion du zombie '{}'", zombie.getNom());
        return zombieDao.insert(zombie);
    }

    @Override
    public Optional<Zombie> getById(int id) {
        logger.info("Service - récupération du zombie id={}", id);
        return zombieDao.getById(id);
    }

    @Override
    public List<Zombie> getAll() {
        logger.info("Service - récupération de tous les zombies");
        return zombieDao.getAll();
    }

    @Override
    public int update(Zombie zombie) {
        logger.info("Service - mise à jour du zombie id={}, nom={}", zombie.getIdZombie(), zombie.getNom());
        return zombieDao.update(zombie);
    }

    @Override
    public int delete(int id) {
        logger.warn("Service - suppression du zombie id={}", id);
        return zombieDao.delete(id);
    }

    @Override
    public List<Zombie> getByMapId(int mapId) {
        logger.info("Service - récupération des zombies pour la map id={}", mapId);
        return zombieDao.getByMapId(mapId);
    }
}
