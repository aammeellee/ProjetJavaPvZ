package com.epf.service;

import com.epf.dao.ZombieDao;
import com.epf.model.Zombie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZombieServiceImpl implements ZombieService {

    private final ZombieDao zombieDao;

    public ZombieServiceImpl(ZombieDao zombieDao) {
        this.zombieDao = zombieDao;
    }

    @Override
    public int insert(Zombie zombie) {
        return zombieDao.insert(zombie);
    }

    @Override
    public Optional<Zombie> getById(int id) {
        return zombieDao.getById(id);
    }

    @Override
    public List<Zombie> getAll() {
        return zombieDao.getAll();
    }

    @Override
    public int update(Zombie zombie) {
        return zombieDao.update(zombie);
    }

    @Override
    public int delete(int id) {
        return zombieDao.delete(id);
    }

    @Override
    public List<Zombie> getByMapId(int mapId) {
        return zombieDao.getByMapId(mapId);
    }
}
