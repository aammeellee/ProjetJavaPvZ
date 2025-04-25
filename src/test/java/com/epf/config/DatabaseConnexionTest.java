package com.epf.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.junit.jupiter.api.Assertions.*;

import com.epf.config.DatabaseConfig;

@SpringJUnitConfig(classes = DataSourceTestConfig.class)

public class DatabaseConnexionTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void testConnectionAndQuery() {
        // Vérifie que jdbcTemplate n'est pas null
        assertNotNull(jdbcTemplate, "JdbcTemplate doit être injecté");

        // Requête simple : test sur une table existante (à adapter si besoin)
        Integer result = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM zombie", Integer.class);
        assertNotNull(result, "La requête doit retourner un résultat");
        System.out.println("Nombre de zombies : " + result);
    }
}
