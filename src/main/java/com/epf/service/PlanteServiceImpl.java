package com.epf.service;

import com.epf.dao.PlanteDao;
import com.epf.model.Plante;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanteServiceImpl implements PlanteService {

    private final PlanteDao planteDao;

    public PlanteServiceImpl(PlanteDao planteDao) {
        this.planteDao = planteDao;
    }

    @Override
    public int insert(Plante plante) {
        return planteDao.insert(plante);
    }

    @Override
    public Optional<Plante> getById(int id) {
        return planteDao.getById(id);
    }

    @Override
    public List<Plante> getAll() {
        return planteDao.getAll();
    }

    @Override
    public int update(Plante plante) {
        return planteDao.update(plante);
    }

    @Override
    public int delete(int id) {
        return planteDao.delete(id);
    }
}
