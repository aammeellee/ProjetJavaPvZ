package com.epf.dao;

import com.epf.model.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MapDaoImpl implements MapDao {

    private static final Logger logger = LoggerFactory.getLogger(MapDaoImpl.class);
    private final JdbcTemplate jdbcTemplate;

    public MapDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Map> mapRowMapper = (rs, rowNum) -> new Map(
            rs.getInt("id_map"),
            rs.getInt("ligne"),
            rs.getInt("colonne"),
            rs.getString("chemin_image")
    );

    @Override
    public int insert(Map map) {
        String sql = "INSERT INTO map (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        logger.debug("DAO - insertion map (ligne={}, colonne={})", map.getLigne(), map.getColonne());
        return jdbcTemplate.update(sql, map.getLigne(), map.getColonne(), map.getCheminImage());
    }

    @Override
    public Optional<Map> getById(int id) {
        String sql = "SELECT * FROM map WHERE id_map = ?";
        logger.debug("DAO - récupération map par id={}", id);
        return jdbcTemplate.query(sql, mapRowMapper, id).stream().findFirst();
    }

    @Override
    public List<Map> getAll() {
        String sql = "SELECT * FROM map";
        logger.debug("DAO - récupération de toutes les maps");
        return jdbcTemplate.query(sql, mapRowMapper);
    }

    @Override
    public int update(Map map) {
        String sql = "UPDATE map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?";
        logger.debug("DAO - mise à jour map id={}, ligne={}, colonne={}", map.getIdMap(), map.getLigne(), map.getColonne());
        return jdbcTemplate.update(sql, map.getLigne(), map.getColonne(), map.getCheminImage(), map.getIdMap());
    }

    @Override
    public int delete(int id) {
        logger.info("DAO - suppression map id={} avec ses zombies associés", id);

        String sqlDeleteZombies = "DELETE FROM zombie WHERE id_map = ?";
        jdbcTemplate.update(sqlDeleteZombies, id);
        logger.debug("DAO - zombies de la map id={} supprimés", id);

        String sqlDeleteMap = "DELETE FROM map WHERE id_map = ?";
        return jdbcTemplate.update(sqlDeleteMap, id);
    }
}
