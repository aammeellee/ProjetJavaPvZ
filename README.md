# Projet Java PvZ - Backend API REST

## Objectif

Développer une API RESTful backend permettant la gestion des données relatives aux entités suivantes :

- Maps
- Plantes
- Zombies

Ce backend est conçu pour être consommé par une application frontend fournie.  
Il implémente une architecture en couches, la persistance des données via JDBC, et respecte les standards de développement attendus.

## Technologies utilisées

- Java 21
- Spring MVC
- Spring JDBC (JdbcTemplate)
- MySQL (base de données principale)
- H2 (base de tests)
- Tomcat 10 (serveur d’application)
- Maven (gestion de projet)
- Jakarta Servlet API
- Spring Security (authentification HTTP Basic)
- Spring Validation (annotations de validation sur DTO)
- Spring Exception Handling (gestion centralisée des erreurs)
- Logback (framework de journalisation)
- JUnit 5 & Mockito (tests unitaires)

## Fonctionnalités implémentées

- Architecture en couches complète : `Controller → Service → DAO → Model`
- Configuration manuelle de Spring MVC avec fichiers XML (`web.xml`, `spring-config.xml`)
- Connexion à la base de données via `JdbcTemplate` et `DataSource`
- Gestion de la validation via `@Valid` et annotations Jakarta sur les DTO
- Gestion centralisée des exceptions avec `@ControllerAdvice`
- Authentification sécurisée par HTTP Basic (Spring Security)
- Logging avec `Logback` (console + fichier)
- Tests unitaires sur toutes les couches (avec base H2 et Mockito)
- Intégration complète avec le frontend fourni

## Lancer le projet (Tomcat)

1. Compiler le projet :

```
mvn clean install
```

2. Déposer le fichier `CoursEpfBack.war` dans :

```
apache-tomcat/webapps/
```

3. Démarrer Tomcat, puis accéder à l’application :

```
http://localhost:8080/CoursEpfBack/
```

## Authentification

L’API est sécurisée via HTTP Basic Authentication.

Identifiants par défaut :

- Utilisateur : `admin`
- Mot de passe : `admin`

## Endpoints disponibles

### Maps

| Méthode | Endpoint   | Description                         |
|---------|------------|-------------------------------------|
| GET     | /maps      | Récupérer toutes les maps           |
| GET     | /maps/{id} | Récupérer une map par ID            |
| POST    | /maps      | Ajouter une nouvelle map            |
| PUT     | /maps/{id} | Modifier une map existante          |
| DELETE  | /maps/{id} | Supprimer une map                   |

### Zombies

| Méthode | Endpoint               | Description                            |
|---------|------------------------|----------------------------------------|
| GET     | /zombies               | Récupérer tous les zombies             |
| GET     | /zombies/{id}          | Récupérer un zombie par ID             |
| POST    | /zombies               | Ajouter un nouveau zombie              |
| PUT     | /zombies/{id}          | Modifier un zombie existant            |
| DELETE  | /zombies/{id}          | Supprimer un zombie                    |
| GET     | /zombies/map/{mapId}   | Récupérer les zombies d'une map donnée |

### Plantes

| Méthode | Endpoint              | Description                            |
|---------|-----------------------|----------------------------------------|
| GET     | /plantes              | Récupérer toutes les plantes           |
| GET     | /plantes/{id}         | Récupérer une plante par ID            |
| POST    | /plantes              | Ajouter une nouvelle plante            |
| PUT     | /plantes/{id}         | Modifier une plante existante          |
| DELETE  | /plantes/{id}         | Supprimer une plante                   |

## Tests unitaires

Les tests utilisent une base de données H2 embarquée.

- Tests DAO : requêtes réelles sur base H2 via JdbcTemplate
- Tests Service : mock des DAO
- Tests Controller : MockMVC avec comportement simulé des services

Pour exécuter les tests :

```
mvn clean test
```

## Structure du projet

```
com.epf
├── config             → Fichiers de configuration Spring / Security / DB
├── controller         → REST Controllers
├── dao                → Interfaces + implémentations JdbcTemplate
├── dto                → Objets de transfert de données (validés)
├── exception          → Gestion des erreurs personnalisées
├── model              → Objets liés à la base de données
├── service            → Interfaces + implémentations métier
```

## Auteur

Abdi A.  
Projet Java "Plantes vs Zombies"  
EPF - Promotion 2026
