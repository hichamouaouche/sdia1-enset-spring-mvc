# SDIA ENSET - Spring MVC Product Management

Une application web de gestion de produits construite avec **Spring Boot 3** et **Spring MVC**, dédiée à l'enseignement de l'architecture JEE et middleware.

## 📋 Table des matières

- [Aperçu](#aperçu)
- [Fonctionnalités](#fonctionnalités)
- [Architecture](#architecture)
- [Prérequis](#prérequis)
- [Installation](#installation)
- [Configuration](#configuration)
- [Utilisation](#utilisation)
- [Utilisateurs par défaut](#utilisateurs-par-défaut)
- [Structure du projet](#structure-du-projet)
- [Technologies utilisées](#technologies-utilisées)

## 🎯 Aperçu

Cette application est un système de gestion de produits avec authentification et autorisation basées sur les rôles. Elle démontre les concepts clés de Spring MVC, Spring Security et la persistance des données avec JPA/Hibernate.

## ✨ Fonctionnalités

- **Authentification sécurisée** : Connexion avec validations
- **Gestion par rôles** : Deux rôles utilisateurs (USER et ADMIN)
- **Affichage des produits** : Liste tous les produits avec détails (nom, prix, quantité)
- **Création de produits** : Formulaire de création réservé aux administrateurs
- **Suppression de produits** : Suppression réservée aux administrateurs
- **Interface responsive** : Design moderne avec Bootstrap 5
- **Données pré-chargées** : Initialization avec 3 produits d'exemple

## 🏗️ Architecture

```
┌─────────────────────────────────────────┐
│         Vue (Thymeleaf + Bootstrap)     │
├─────────────────────────────────────────┤
│         Contrôleur (ProductController)  │
├─────────────────────────────────────────┤
│         Métier & Sécurité (Spring)      │
├─────────────────────────────────────────┤
│  Couche Données (JPA/Hibernate + H2)    │
└─────────────────────────────────────────┘
```

### Composants principaux

- **ProductController** : Gère les requêtes HTTP et le routage
- **Product** : Entité JPA représentant un produit
- **ProductRepository** : Interface d'accès aux données (JpaRepository)
- **SecurityConfig** : Configuration de Spring Security avec authentification en mémoire

## 🔐 Contrôle d'accès

| Endpoint | Rôle requis | Description |
|----------|-----------|-------------|
| `/user/index` | USER | Affiche la liste des produits |
| `/admin/newProduct` | ADMIN | Formulaire de création de produit |
| `/admin/saveProduct` | ADMIN | Enregistre un nouveau produit |
| `/admin/delete` | ADMIN | Supprime un produit |
| `/login` | Aucun | Page de connexion |
| `/logout` | Authentifié | Déconnexion |

## 📋 Prérequis

- **Java 21** ou supérieur
- **Maven 3.6+**
- Un terminal/invite de commande

## 🚀 Installation

### 1. Cloner ou télécharger le projet

```bash
cd f:\SDIA_S2\Architecture JEE et Middlewate\sdia1-enset-spring-mvc
```

### 2. Compiler le projet

```bash
mvn clean compile
```

### 3. Démarrer l'application

```bash
mvn spring-boot:run
```

Ou en utilisant le script Maven :

```bash
./mvnw spring-boot:run
```

## ⚙️ Configuration

Les paramètres de configuration se trouvent dans [src/main/resources/application.properties](src/main/resources/application.properties) :

```properties
spring.application.name=sdia-enset-spring-mvc
spring.datasource.url=jdbc:h2:mem:products-db
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
server.port=8094
spring.h2.console.enabled=true
```

### Configuration détaillée

| Propriété | Valeur | Description |
|-----------|--------|-------------|
| `server.port` | 8094 | Port d'écoute de l'application |
| `spring.datasource.url` | jdbc:h2:mem:products-db | Base de données H2 en mémoire |
| `spring.h2.console.enabled` | true | Actif le console H2 (http://localhost:8094/h2-console) |
| `spring.jpa.hibernate.ddl-auto` | update | Crée/met à jour automatiquement le schéma BD |

## 🎮 Utilisation

### Démarrage

1. Lancez l'application : `mvn spring-boot:run`
2. Accédez à l'application : http://localhost:8094
3. Vous serez redirigé vers la page de connexion

### Accès console H2

- URL : http://localhost:8094/h2-console
- Username : `sa`
- Password : (laisser vide)
- URL JDBC : `jdbc:h2:mem:products-db`

## 👥 Utilisateurs par défaut

Trois utilisateurs sont préconfigurés dans [SecurityConfig.java](src/main/java/hiou/hicham/sdiaensetspringmvc/config/SecurityConfig.java) :

| Username | Password | Rôles |
|----------|----------|-------|
| `user1` | `1234` | USER |
| `user2` | `1234` | USER |
| `admin` | `1234` | USER, ADMIN |

## 📁 Structure du projet

```
sdia1-enset-spring-mvc/
├── src/
│   ├── main/
│   │   ├── java/hiou/hicham/sdiaensetspringmvc/
│   │   │   ├── SdiaEnsetSpringMvcApplication.java      # Point d'entrée
│   │   │   ├── config/
│   │   │   │   └── SecurityConfig.java                 # Configuration sécurité
│   │   │   ├── entities/
│   │   │   │   └── Product.java                        # Entité métier
│   │   │   ├── repository/
│   │   │   │   └── ProductRepository.java              # Interface d'accès données
│   │   │   └── web/
│   │   │       └── ProductController.java              # Contrôleur MVC
│   │   └── resources/
│   │       ├── application.properties                  # Configuration
│   │       └── templates/
│   │           ├── layout1.html                        # Layout principal
│   │           ├── login.html                          # Page de connexion
│   │           ├── products.html                       # Liste des produits
│   │           ├── new-product.html                    # Formulaire créations
│   │           └── notAuthorized.html                  # Page d'erreur accès
│   └── test/
│       └── java/...                                    # Tests unitaires
├── pom.xml                                             # Dépendances Maven
└── mvnw, mvnw.cmd                                      # Scripts Maven
```

## 🛠️ Technologies utilisées

### Framework & Core

- **Spring Boot 3.5.11** : Framework principal
- **Spring MVC** : Architecture web
- **Spring Security 6** : Authentification et autorisation
- **Spring Data JPA** : Couche de persistance

### Persistance & Base de données

- **Hibernate** : ORM (inclus dans Spring Data JPA)
- **H2 Database** : Base de données embarquée en mémoire
- **MySQL Connector** : Support optionnel pour MySQL

### Frontend

- **Thymeleaf 3** : Template engine
- **Thymeleaf Layout Dialect** : Gestion des layouts
- **Bootstrap 5.3** : Framework CSS responsive
- **WebJars** : Gestion des ressources web

### Outils & Utilitaires

- **Maven 3** : Gestion des dépendances et build
- **Lombok** : Génération de code boilerplate
- **Jakarta Validation** : Validation des données

## 📚 Points clés d'apprentissage

Ce projet illustre les concepts suivants :

1. **Architecture MVC** : Séparation des responsabilités
2. **Spring Security** : Configuration d'authentification et d'autorisation
3. **JPA & Hibernate** : Mapping objet-relationnel
4. **Validation** : Validation des entités avec @Valid et @NotEmpty
5. **Thymeleaf** : Templating dynamique côté serveur
6. **Responsive Design** : Interface adaptée aux écrans
7. **Best Practices** : Injection de dépendances, builders, etc.

## 🔍 Données initiales

Trois produits sont créés automatiquement au démarrage :

```
1. Computer   - 5400 € (Quantité: 12)
2. Printer    - 1200 € (Quantité: 11)
3. Smart Phone - 120 € (Quantité: 33)
```

## 📝 Notes importantes

- Les mots de passe utilisateurs sont encodés avec **BCrypt**
- La base de données H2 est **en mémoire** (réinitialisée à chaque redémarrage)
- Les fichiers statiques (CSS, JS) sont servis depuis `/webjars/`
- CSRF est activé par défaut
- Les accès non autorisés redirigent vers `/notauthorized`

## 🎓 Cas d'usage

### Pour les utilisateurs (USER)

1. Se connecter à l'application
2. Consulter la liste des produits
3. Voir les détails de chaque produit

### Pour les administrateurs (ADMIN)

1. Effectuer toutes les actions USER
2. Créer de nouveaux produits
3. Supprimer des produits existants
4. Gérer la base de données

## 📞 Support & Contribution

Ce projet est utilisé à titre éducatif dans le cadre du cursus SDIA à ENSET. Pour toute question ou contribution, veuillez consulter votre instructeur.

---

**Développé pour l'enseignement de l'Architecture JEE et Middleware | SDIA - ENSET**
