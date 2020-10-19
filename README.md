# E-commerce

##  Sommaire


- [Présentation du projet](#présentation-du-projet)
- [Qui sommes-nous ?](#qui-sommes-nous-)
- [Structure](#structure)
- [License](#license)

## Présentation du projet
Ce repository contient le code source d'un projet web d'E-commerce factice. L'objectif du projet est de « monter en compétences » en réalisant une application faisant appel à des concepts avancés dans deux technologies orientées web, à savoir :

- [Spring](https://spring.io/) (Java)
- [Angular](https://angular.io/) (Typescript)

L'application est composée de deux parties : 

- Un **back-end**, côté serveur et développé sous forme d'API REST. Il est responsable de la réception et du traitement de requêtes HTTP.
- Un **front-end**, côté client et développé sous forme de deux Single Page Applications (SPAs) :
  - Une représentant le **front-office**, c'est-à-dire la partie exposée aux clients de l'application d'E-commerce.
  - Une représentant le **back-office**, c'est-à -dire la partie réservée aux employés chargés de la surveillance de l'application ainsi que de la maintenance des données (articles, commandes, etc.).

## Qui sommes-nous ?

Ce projet est développé par deux étudiants en Master d'Ingénierie du Logiciel et des Données à Aix-Marseille Université :

- [Victoria Niaba](https://github.com/VictoriaNiaba)
- [Nicolas Desnoust](https://github.com/NicolasDesnoust)

## Structure

La structure du projet est présentée dans l'arbre ci-dessous :

```yaml
E-COMMERCE
|   LICENSE.md # Licence du projet
|
+---back-end
|   |   .gitignore
|   |   mvnw # Wrapper de Maven pour Linux
|   |   mvnw.cmd # Wrapper de Maven pour Windows
|   |   pom.xml # Informations sur le projet et configuration Maven 
|   |
|   \---src
|       +---main # Sources du back-end
|       |   +---java\com\ecommerce\backend
|       |   |   	BackEndApplication.java # Starter du back-end
|       |   |
|       |   \---resources # Resources 
|       |           application.properties # Configuration du back-end
|       |
|       \---test # Sources des tests du back-end
|           \---java\com\ecommerce\backend
|                   BackEndApplicationTests.java # Exemple de test
|
\---front-end # Espace de travail Angular
    |   angular.json
    |   package-lock.json
    |   package.json
    |   tsconfig.json
    |   tslint.json
    |
    +---node_modules # Librairies externes
    \---projects # Contient les projets Angular
        +---back-office # Sa structure est similaire à celle du front-office 
        \---front-office
            |   tsconfig.app.json
            |   tsconfig.spec.json
            |   tslint.json
            |
            +---e2e # Tests end-to-end
            \---src
                |   favicon.ico # Icône
                |   index.html # Page principale
                |   main.ts # Point d'entrée
                |   polyfills.ts # Scripts permettant le support de navigateurs obsolètes
                |   styles.scss # Feuille de style principale
                |   test.ts # Point d'entrée des tests unitaires
                |
                +---app # Contient les composants (et autres éléments) du projet
                |       app-routing.module.ts
                |       app.component.ts
                |       app.module.ts
                |
                +---assets # Images et autres fichiers à copier tels-quels lors du build
                \---environments # Configurations spécifiques à chaque environnement
                        environment.prod.ts
                        environment.ts

```

## Liens utiles

Cette section regroupe les liens/sources utiles au développement de ce projet. 

### Back-end

- [*Designer une API REST | OCTO Talks !*](https://blog.octo.com/designer-une-api-rest/) (2014, 1 décembre). Octo.
- [ProgrammingIsFun](https://www.youtube.com/c/ProgrammingIsFun). (2020, 19 mars). *[Ecommerce App - Angular 9, NodeJs And MySQL](https://www.youtube.com/playlist?list=PLsjmv9aDmNDAN5adZxbGTlQHlgU2je7KE)* [PlayList]. YouTube.
- B. (2020, 20 juillet). *[A Simple E-Commerce Implementation with Spring.](https://www.baeldung.com/spring-angular-ecommerce)* Baeldung.

### Divers

- [Roadmap du projet.](https://trello.com/b/JRqCs0QV/e-commerce) Trello

## License

Voir le fichier LICENCE.md pour plus de détails. Si vous souhaitez utiliser notre projet et que vous jugez la licence actuelle trop restrictive, n'hésitez pas à nous contacter par e-mail :

desnoust.nicolas451@gmail.com ou niaba.victoria@gmail.com

