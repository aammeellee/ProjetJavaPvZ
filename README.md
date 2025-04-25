# Projet Java PvZ - Backend API REST

## Objectif

Développement d'une API RESTful en Java permettant la gestion des entités suivantes :

- Maps
- Plantes
- Zombies

L'application est intégrée à un frontend fourni, qui consomme cette API.

## Technologies utilisées

- Java 21
- Spring MVC
- Spring JDBC (JdbcTemplate)
- MySQL (production)
- H2 (environnement de test)
- Tomcat 10
- Maven
- JUnit 5
- Spring Security (authentification)
- Spring Validation (validation des données)
- Spring Exception Handling (gestion des erreurs)

## Fonctionnalités techniques implémentées

- Architecture en couches (controller / service / repository / model / dto)
- Connexion à la base de données via JdbcTemplate
- Système de validation des données (DTO annotés avec `@NotBlank`, `@Min`, etc.)
- Gestion centralisée des exceptions avec `@ControllerAdvice`
- Sécurisation de l'API avec Spring Security (authentification basique)
- Tests unitaires avec base de données H2 en mémoire
- Configuration de l'environnement XML (Spring MVC, Security)

## Lancer le projet (Tomcat)

1. Compiler le projet :

mvn clean install

2. Déposer le fichier WAR généré dans :

apache-tomcat/webapps/CoursEpfBack.war


3. Démarrer Tomcat, puis accéder à l'application via :

http://localhost:8080/CoursEpfBack/


## Authentification

L'accès aux endpoints est protégé par une authentification HTTP Basic.

Identifiants par défaut :

- Nom d'utilisateur : `admin`
- Mot de passe : `admin`

## Endpoints disponibles

### Maps

| Méthode | Endpoint   | Description               |
| ------- | ---------- | ------------------------- |
| GET     | /maps      | Récupérer toutes les maps |
| GET     | /maps/{id} | Récupérer une map par ID  |
| POST    | /maps      | Créer une nouvelle map    |
| PUT     | /maps/{id} | Modifier une map existante|
| DELETE  | /maps/{id} | Supprimer une map         |

### Zombies

| Méthode | Endpoint       | Description                             |
| ------- | -------------- | --------------------------------------- |
| GET     | /zombies       | Récupérer tous les zombies              |
| GET     | /zombies/{id}  | Récupérer un zombie par ID              |
| POST    | /zombies       | Créer un nouveau zombie                 |
| PUT     | /zombies/{id}  | Modifier un zombie                      |
| DELETE  | /zombies/{id}  | Supprimer un zombie                     |
| GET     | /zombies/map/{mapId} | Récupérer les zombies d'une map précise |

### Plantes

| Méthode | Endpoint       | Description                  |
| ------- | -------------- | ---------------------------- |
| GET     | /plantes       | Récupérer toutes les plantes |
| GET     | /plantes/{id}  | Récupérer une plante par ID  |
| POST    | /plantes       | Créer une nouvelle plante    |
| PUT     | /plantes/{id}  | Modifier une plante existante|
| DELETE  | /plantes/{id}  | Supprimer une plante         |

## Tests unitaires

Les tests s'exécutent sur une base de données H2 embarquée, avec des scripts SQL d'initialisation.

Pour exécuter les tests :

mvn clean test


## Auteur

Abdi A.  
Projet Java Plantes vs Zombies  
EPF - Promotion 2026

