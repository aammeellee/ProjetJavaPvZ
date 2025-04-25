package com.epf.dao;

import com.epf.model.Zombie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ZombieDaoImpl implements ZombieDao {

    private static final Logger logger = LoggerFactory.getLogger(ZombieDaoImpl.class);
    private final JdbcTemplate jdbcTemplate;

    public ZombieDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Zombie> zombieRowMapper = (rs, rowNum) -> new Zombie(
            rs.getInt("id_zombie"),
            rs.getString("nom"),
            rs.getInt("point_de_vie"),
            rs.getDouble("attaque_par_seconde"),
            rs.getInt("degat_attaque"),
            rs.getDouble("vitesse_de_deplacement"),
            rs.getString("chemin_image"),
            rs.getInt("id_map")
    );

    @Override
    public int insert(Zombie zombie) {
        logger.debug("DAO - insertion du zombie '{}'", zombie.getNom());
        String sql = "INSERT INTO zombie (nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, zombie.getNom(), zombie.getPointDeVie(), zombie.getAttaqueParSeconde(),
                zombie.getDegatAttaque(), zombie.getVitesseDeDeplacement(), zombie.getCheminImage(), zombie.getIdMap());
    }

    @Override
    public Optional<Zombie> getById(int id) {
        logger.debug("DAO - récupération du zombie id={}", id);
        String sql = "SELECT * FROM zombie WHERE id_zombie = ?";
        return jdbcTemplate.query(sql, zombieRowMapper, id).stream().findFirst();
    }

    @Override
    public List<Zombie> getAll() {
        logger.debug("DAO - récupération de tous les zombies");
        String sql = "SELECT * FROM zombie";
        return jdbcTemplate.query(sql, zombieRowMapper);
    }

    @Override
    public int update(Zombie zombie) {
        logger.debug("DAO - mise à jour du zombie id={}, nom='{}'", zombie.getIdZombie(), zombie.getNom());
        String sql = "UPDATE zombie SET nom=?, point_de_vie=?, attaque_par_seconde=?, degat_attaque=?, vitesse_de_deplacement=?, chemin_image=?, id_map=? " +
                "WHERE id_zombie=?";
        return jdbcTemplate.update(sql, zombie.getNom(), zombie.getPointDeVie(), zombie.getAttaqueParSeconde(),
                zombie.getDegatAttaque(), zombie.getVitesseDeDeplacement(), zombie.getCheminImage(), zombie.getIdMap(), zombie.getIdZombie());
    }

    @Override
    public int delete(int id) {
        logger.info("DAO - suppression du zombie id={}", id);
        String sql = "DELETE FROM zombie WHERE id_zombie=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Zombie> getByMapId(int mapId) {
        logger.debug("DAO - récupération des zombies de la map id={}", mapId);
        String sql = "SELECT * FROM zombie WHERE id_map = ?";
        return jdbcTemplate.query(sql, zombieRowMapper, mapId);
    }
}
