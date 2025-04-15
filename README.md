# Projet Java PvZ - Backend API REST

## 🌟 Objectif

Développement d'une API RESTful en Java permettant de gérer :

- des Maps
- des Plantes
- des Zombies



## ⚙️ Technologies utilisées

- Java 21
- Spring MVC
- Spring JDBC
- MySQL
- Tomcat 10
- Maven
- JUnit 5
- H2 (pour les tests)



## 📦 Lancer le projet (Tomcat)

1. Compiler le projet :

```
mvn clean install
```

2. Déposer le fichier WAR dans :

```
apache-tomcat/webapps/CoursEpfBack.war
```

3. Démarrer Tomcat et accéder à :

```
http://localhost:8080/CoursEpfBack/
```



## 📚 Endpoints API disponibles

### MAPS

| Méthode | Endpoint   | Description               |
| ------- | ---------- | ------------------------- |
| GET     | /maps      | Récupérer toutes les maps |
| GET     | /maps/{id} | Récupérer une map par id  |
| POST    | /maps      | Créer une nouvelle map    |
| PUT     | /maps/{id} | Modifier une map          |
| DELETE  | /maps/{id} | Supprimer une map         |

### ZOMBIES

| Méthode | Endpoint      | Description                             |
| ------- | ------------- | --------------------------------------- |
| GET     | /zombies      | Récupérer tous les zombies              |
| GET     | /zombies/{id} | Récupérer un zombie par id              |
| POST    | /zombies      | Créer un nouveau zombie                 |
| PUT     | /zombies/{id} | Modifier un zombie                      |
| DELETE  | /zombies/{id} | Supprimer un zombie                     |
| GET     | /map/{mapId}  | Récupérer les zombies d'une map précise |

### PLANTES

| Méthode | Endpoint      | Description                  |
| ------- | ------------- | ---------------------------- |
| GET     | /plantes      | Récupérer toutes les plantes |
| GET     | /plantes/{id} | Récupérer une plante par id  |
| POST    | /plantes      | Créer une nouvelle plante    |
| PUT     | /plantes/{id} | Modifier une plante          |
| DELETE  | /plantes/{id} | Supprimer une plante         |

## 🔮 Tests unitaires

Exécuter les tests :

```
mvn clean test
```

## 👤 Développeur

Abdi A.\
Projet Java Plant VS Zombie - EPF MIN2 - P2026

