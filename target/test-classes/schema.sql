DROP TABLE IF EXISTS zombie;
DROP TABLE IF EXISTS plante;
DROP TABLE IF EXISTS map;

CREATE TABLE map (
    id_map INT AUTO_INCREMENT PRIMARY KEY,
    ligne INT NOT NULL,
    colonne INT NOT NULL,
    chemin_image VARCHAR(255) DEFAULT NULL
);

CREATE TABLE plante (
    id_plante INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    point_de_vie INT NOT NULL,
    attaque_par_seconde DECIMAL(5,2) DEFAULT 0.00,
    degat_attaque INT DEFAULT 0,
    cout INT NOT NULL,
    soleil_par_seconde DECIMAL(5,2) DEFAULT 0.00,
    effet VARCHAR(50) DEFAULT 'normal',
    chemin_image VARCHAR(255) DEFAULT NULL
);

CREATE TABLE zombie (
    id_zombie INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    point_de_vie INT NOT NULL,
    attaque_par_seconde DECIMAL(5,2) DEFAULT 0.00,
    degat_attaque INT NOT NULL,
    vitesse_de_deplacement DECIMAL(5,2) DEFAULT 0.00,
    chemin_image VARCHAR(255) DEFAULT NULL,
    id_map INT,
    CONSTRAINT fk_zombie_map FOREIGN KEY (id_map) REFERENCES map(id_map)
);
