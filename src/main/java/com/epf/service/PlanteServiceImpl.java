package com.epf.service;

import com.epf.dao.PlanteDao;
import com.epf.model.Plante;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanteServiceImpl implements PlanteService {

    private static final Logger logger = LoggerFactory.getLogger(PlanteServiceImpl.class);
    private final PlanteDao planteDao;

    public PlanteServiceImpl(PlanteDao planteDao) {
        this.planteDao = planteDao;
    }

    @Override
    public int insert(Plante plante) {
        logger.info("Service - insertion de la plante '{}'", plante.getNom());
        return planteDao.insert(plante);
    }

    @Override
    public Optional<Plante> getById(int id) {
        logger.info("Service - récupération de la plante id={}", id);
        return planteDao.getById(id);
    }

    @Override
    public List<Plante> getAll() {
        logger.info("Service - récupération de toutes les plantes");
        return planteDao.getAll();
    }

    @Override
    public int update(Plante plante) {
        logger.info("Service - mise à jour de la plante id={}, nom={}", plante.getIdPlante(), plante.getNom());
        return planteDao.update(plante);
    }

    @Override
    public int delete(int id) {
        logger.warn("Service - suppression de la plante id={}", id);
        return planteDao.delete(id);
    }
}
