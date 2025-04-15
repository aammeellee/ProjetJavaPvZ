package com.epf.dao;

import com.epf.model.Plante;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PlanteDaoImpl implements PlanteDao {

    private final JdbcTemplate jdbcTemplate;

    public PlanteDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Plante> planteRowMapper = (rs, rowNum) -> new Plante(
            rs.getInt("id_plante"),
            rs.getString("nom"),
            rs.getInt("point_de_vie"),
            rs.getDouble("attaque_par_seconde"),
            rs.getInt("degat_attaque"),
            rs.getInt("cout"),
            rs.getDouble("soleil_par_seconde"),
            rs.getString("effet"),
            rs.getString("chemin_image")
    );

    @Override
    public int insert(Plante plante) {
        String sql = "INSERT INTO plante (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, plante.getNom(), plante.getPointDeVie(), plante.getAttaqueParSeconde(),
                plante.getDegatAttaque(), plante.getCout(), plante.getSoleilParSeconde(),
                plante.getEffet(), plante.getCheminImage());
    }

    @Override
    public Optional<Plante> getById(int id) {
        String sql = "SELECT * FROM plante WHERE id_plante = ?";
        return jdbcTemplate.query(sql, planteRowMapper, id).stream().findFirst();
    }

    @Override
    public List<Plante> getAll() {
        String sql = "SELECT * FROM plante";
        return jdbcTemplate.query(sql, planteRowMapper);
    }

    @Override
    public int update(Plante plante) {
        String sql = "UPDATE plante SET nom=?, point_de_vie=?, attaque_par_seconde=?, degat_attaque=?, cout=?, soleil_par_seconde=?, effet=?, chemin_image=? " +
                "WHERE id_plante=?";
        return jdbcTemplate.update(sql, plante.getNom(), plante.getPointDeVie(), plante.getAttaqueParSeconde(),
                plante.getDegatAttaque(), plante.getCout(), plante.getSoleilParSeconde(),
                plante.getEffet(), plante.getCheminImage(), plante.getIdPlante());
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM plante WHERE id_plante=?";
        return jdbcTemplate.update(sql, id);
    }
}
