package com.epf.dao;

import com.epf.model.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class MapDaoImpl implements MapDao {

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
        return jdbcTemplate.update(sql, map.getLigne(), map.getColonne(), map.getCheminImage());
    }

    @Override
    public Optional<Map> getById(int id) {
        String sql = "SELECT * FROM map WHERE id_map = ?";
        return jdbcTemplate.query(sql, mapRowMapper, id)
                .stream()
                .findFirst();
    }

    @Override
    public List<Map> getAll() {
        String sql = "SELECT * FROM map";
        return jdbcTemplate.query(sql, mapRowMapper);
    }

    @Override
    public int update(Map map) {
        String sql = "UPDATE map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?";
        return jdbcTemplate.update(sql, map.getLigne(), map.getColonne(), map.getCheminImage(), map.getIdMap());
    }

    @Override
    public int delete(int id) {
        // 1. Supprimer les zombies associés à la map
        String sqlDeleteZombies = "DELETE FROM zombie WHERE id_map = ?";
        jdbcTemplate.update(sqlDeleteZombies, id);

        // 2. Supprimer ensuite la map
        String sqlDeleteMap = "DELETE FROM map WHERE id_map = ?";
        return jdbcTemplate.update(sqlDeleteMap, id);
    }

}
