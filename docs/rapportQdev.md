# Rapport de qualité de dev

## **Introduction aux normes ISO**

Les normes ISO (Organisation internationale de normalisation) sont des documents établissant des spécifications, des exigences ou des recommandations pour garantir la qualité, la sécurité, l'efficacité et l'interopérabilité des produits, services ou systèmes. Elles sont élaborées par des experts internationaux et visent à harmoniser les pratiques à l'échelle mondiale.

Dans le domaine de la technologie de l'information et des logiciels, plusieurs normes ont été créées pour définir et évaluer la qualité des logiciels. Parmi celles-ci, l'évolution des normes ISO/IEC 9126 et ISO/IEC 25010 est particulièrement significative.



### **ISO/IEC 9126 : Qualité Logicielle**

#### **ISO/IEC 9126:1991**
Publiée le **19 décembre 1991**, cette norme introduisait une méthode pour évaluer la qualité des logiciels. Elle définissait **six critères principaux** permettant d'évaluer les logiciels de manière systématique.

#### **ISO/IEC 9126:2001**
Le **15 juin 2001**, une mise à jour de cette norme a été publiée. Elle remplaçait l'ancienne version et la divisait en **quatre parties distinctes** pour mieux structurer les aspects de la qualité logicielle. Ces parties abordaient :
- La qualité interne,
- La qualité externe,
- La qualité en utilisation,
- Les mesures pour évaluer ces qualités.

Ces normes appartiennent à la catégorie **Technologie de l'information : Qualité Logicielle**.



### **ISO/IEC 25010 : Modèle de qualité SQUARE**

Le **1er mars 2011**, la norme **ISO/IEC 25010** a remplacé la norme ISO/IEC 9126. Elle est regroupée dans la catégorie **Ingénierie des systèmes et du logiciel : Critères de qualité et évaluation**.  
Cette norme introduit un modèle élargi, appelé **SQUARE Quality Model**, qui repose sur **huit critères principaux** (contre six précédemment). Les deux nouveaux critères ajoutés sont :
1. **Sécurité** : capacité du logiciel à protéger les données et à garantir la confidentialité et l'intégrité.
2. **Compatibilité** : capacité à fonctionner avec d'autres produits ou systèmes.

Les six critères principaux de l'ancienne norme sont également repris et enrichis.


### **ISO/IEC 25041 : Guide d'évaluation**

La norme **ISO/IEC 25041** propose un guide pratique pour les développeurs, leur permettant d'évaluer la qualité des logiciels en suivant un processus en **quatre étapes clés** :
1. **Fixer les exigences de qualité** : définir les attentes et les besoins spécifiques.
2. **Établir un modèle de qualité** : utiliser le modèle **ISO/IEC 25010** pour structurer l'évaluation.
3. **Fixer les métriques de qualité** : s'appuyer sur la norme **ISO/IEC 25002** pour mesurer la qualité en utilisation.
4. **Conduire les évaluations** : appliquer les métriques et analyser les résultats pour améliorer le logiciel.


## **Portée de la Norme Iso (Scope)**
La norme définit deux modèles de qualité :

1. **Quality in Use Model (Qualité en utilisation)**
    - Se concentre sur **l’interaction entre l’utilisateur et le produit** dans un contexte d’utilisation spécifique.
    - Composé de **5 caractéristiques**, subdivisées en sous-caractéristiques.
    - Applicable aux systèmes humains-informatiques : concerne les logiciels et systèmes utilisés directement par des utilisateurs humains, en évaluant l’interaction et l’expérience utilisateur dans un contexte spécifique.

2. **Product Quality Model (Qualité du produit)**
    - Analyse les **propriétés statiques** (structurelles) et **dynamiques** (comportement en exécution) du logiciel ou du système informatique.
    - Composé de **8 caractéristiques**, subdivisées en sous-caractéristiques.
    - Applicable aux produits techniques eux-mêmes, en analysant leurs propriétés internes et externes, et peut également inclure des systèmes complexes comme des infrastructures cloud (ex. : AWS) ou des services techniques tels que des plateformes de streaming (ex. : Netflix).



#### **Différence entre "Quality in Use" et "Product Quality"**

| **Aspect**                 | **Quality in Use**                                                                                      | **Product Quality**                                                                                      |
|----------------------------|--------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------|
| **Objectif principal**      | Évaluer **l'expérience utilisateur** et les résultats obtenus lors de l'utilisation du produit.         | Évaluer **les caractéristiques intrinsèques** du produit (statique et dynamique).                        |
| **Contexte d'application** | Analyse **en situation réelle** d'utilisation dans un contexte particulier.                            | Analyse des propriétés du produit indépendamment d'un contexte spécifique d'utilisation.                |
| **Caractéristiques**        | 5 caractéristiques principales, centrées sur l’utilisateur (ex. : efficacité, satisfaction).           | 8 caractéristiques principales, centrées sur le produit (ex. : performance, maintenabilité, sécurité).   |
| **Exemples d’usage**        | - Mesurer la satisfaction utilisateur. <br>- Identifier les problèmes d'ergonomie ou d'efficacité.     | - Identifier des objectifs de conception. <br>- Définir des critères d'acceptation du produit logiciel.  |
| **Portée**                  | Concerne **l’ensemble du système humain-machine** (interface, interactions, etc.).                    | Concerne **les systèmes informatiques et logiciels eux-mêmes**, sans inclure directement l’utilisateur. |

## Quality in Use

Le modèle **Quality in Use** comme dit précédemment évalue la qualité d'un produit ou système en fonction de son utilisation réelle par l'utilisateur, en prenant en compte l'impact qu'il a sur l'utilisateur dans un contexte donné. Il est évalué sur cinq caractéristiques principales :

### 1. **Effectiveness (Efficacité)**
- **Effectiveness** mesure si un produit permet à l'utilisateur de réaliser la tâche prévue avec succès.

### 2. **Efficiency (Efficience)**
- **Efficiency** évalue la manière dont un produit permet à l'utilisateur d'accomplir une tâche avec un minimum de ressources (le temps et les ressources matérielles).

### 3. **Satisfaction**
- **Satisfaction** mesure l'expérience subjective de l'utilisateur d'un produit dans un contexte spécifique
    - **Usefulness (Utilité)** : La capacité du produit à répondre aux besoins de l'utilisateur. Par exemple, un logiciel de gestion de projet est utile si ses fonctionnalités aident l'utilisateur à accomplir ses tâches efficacement.
    - **Trust (Confiance)** : La fiabilité du produit, c'est-à-dire si l'utilisateur peut lui faire confiance pour accomplir les tâches sans erreurs ni pannes.
    - **Pleasure (Plaisir)** : Le plaisir que l'utilisateur ressent en utilisant le produit. Lié à la facilité d'interaction.
    - **Comfort (Confort)** : Le confort physique et mental que l'utilisateur ressent pendant l'utilisation du produit, lié à l'ergonomie et l'attrait esthétique.

#### Exemple de **Satisfaction** avec le tableau que tu as fourni :

| **Logiciel**    | **Star UML**                        | **Excalisraw**                        |
|-----------------|-------------------------------------|---------------------------------------|
| **Usefulness**  | Utile pour diagramme UML            | Utile pour modèle de conception avec UML | Utile pour dessiner des diagrammes dont UML |
| **Trust**       | Respecte la norme                   | Ne respecte pas la norme              |
| **Pleasure**    | Demande de connaître UML            | Pas d'exigence technique dans l’utilisation |
| **Comfort**     | Bof                                 | Bien                                  |

- **Usefulness (Utilité)** : Les deux logiciels sont utiles pour des tâches similaires, mais Star UML est spécifiquement conçu pour les diagrammes UML, ce qui le rend plus utile pour ce cas précis pour la conception UML.
- **Trust (Confiance)** : Star UML respecte les normes pour la conception d'UML, ce qui inspire davantage confiance, tandis qu'Excalisraw ne respecte pas les normes pour les UML,l'utilisateur ne peut pas faire confiance à excalidraw pour lui de faire des erreurs de conceptions UML.
- **Pleasure (Plaisir)** : L'utilisation de Star UML peut être moins plaisante car elle nécessite de connaître UML, tandis qu'Excalisraw est plus simple d'utilisation sans exigences techniques particulières.
- **Comfort (Confort)** : Le confort d'utilisation de Star UML est moyen ("bof"), tandis qu'Excalisraw offre une meilleure expérience ("bien").


### 4. **Freedom from Risk (Liberté de risque)**
- Cette caractéristique mesure dans quelle mesure un produit minimise les risques pour l'utilisateur. Cela inclut :
    - **Economic risk mitigation** (Atténuation du risque économique) : Réduction des risques financiers liés à l’utilisation du produit, par exemple, en réduisant les coûts d'exploitation ou en évitant les pertes financières dues à des erreurs.
    - **Health and safety risk mitigation** (Atténuation des risques de santé et de sécurité) : Réduction des risques pour la santé et la sécurité des utilisateurs, notamment dans des contextes comme l'usage de logiciels médicaux ou industriels.
    - **Environmental risk mitigation** (Atténuation des risques environnementaux) : Réduction des risques environnementaux associés à l'utilisation du produit, comme la consommation d'énergie.

### 5. **Context Coverage (Couverture du contexte)**
- **Context Coverage** mesure l'adaptabilité du produit à différents environnements d'utilisation. Cela inclut :
    - **Context completeness** (Complétude du contexte) : La capacité du produit à fonctionner de manière optimale dans différents contextes d’utilisation, comme différents systèmes d'exploitation, configurations matérielles ou environnements réseau.
    - **Flexibility** (Flexibilité) : La capacité du produit à s'adapter à différents besoins ou scénarios d’utilisation, comme la personnalisation ou l’extension des fonctionnalités.

## Product Quality
Le modèle Product Quality évalue la qualité intrinsèque d’un produit logiciel ou système informatique en se basant sur ses propriétés statiques et dynamiques. Il repose sur huit caractéristiques principales :

### 1. **Functional Suitability (Adéquation fonctionnelle)**
**Functional Suitability** évalue si le produit remplit toutes les **fonctions nécessaires** et si ces fonctions sont appropriées pour les tâches des utilisateurs.

- **Functional Completeness (Complétude fonctionnelle)**  
  Vérifie si **toutes les fonctionnalités nécessaires** sont présentes dans le produit pour répondre aux besoins des utilisateurs.  
  **Exemple** : Une application bancaire doit avoir comme fonctionnalité de consulter le solde, mais aussi d’effectuer des virements et de consulter l'historique des transactions

- **Functional Correctness (Correction fonctionnelle)**  
  Vérifie si ces fonctionnalités produisent des **résultats corrects** et conformes aux attentes de l’utilisateur.  
  **Exemple** : Lors d’un virement bancaire, le montant est **correctement déduit** du compte de l'expéditeur et **ajouté** au compte du destinataire, sans erreurs dans le processus.

- **Functional Appropriateness (Pertinence fonctionnelle)**  
  Vérifie si les fonctionnalités présentes sont **adaptées et efficaces** pour accomplir les tâches spécifiques.  
  **Exemple** : Pour faire une tra&nsaction banquaire , je n'ai besoin que de mettre le montant et de valider, il ne faut pas rajouter d'étapes superflues


### 2. **Performance Efficiency (Efficacité de la performance)**
**Performance Efficiency** évalue si le produit utilise les **ressources efficacement** pour répondre aux exigences de performance. Cela inclut la gestion du temps, l’utilisation des ressources et la capacité.

- **Time-behaviour (Comportement temporel)**
  Vérifie si le produit répond dans un **délai raisonnable** et sans latence excessive.  
  **Exemple** : Une application de messagerie qui envoie un message en moins de 2 secondes.

- **Resource Utilisation (Utilisation des ressources)**  
  Vérifie si le produit utilise les ressources (comme la mémoire, le processeur) de manière **optimale** et efficace pour satisfaire ses spécifications.  
  **Exemple** : un algorithme de Montecarlo prend 8 heures à se faire avec un processeur, la spécification dit que cette algo doit se faire en 2 heures donc on utilise 4 processeurs

- **Capacity (Capacité)**  
  mesure le minimal de ressources hardware sans perte de performance.  
  **Exemple** : Mon algo de Montecarlo a besoin de 4 giga de ram pour marcher. Donc je ne peux pas utiliser une machine de moins de 4 giga


### 3. **Compatibility (Compatibilité)**
**Compatibility** évalue si le produit peut fonctionner avec d’autres systèmes, logiciels ou équipements.

- **Coexistence (Coexistence)**  
  Vérifie si le produit peut fonctionner en **concurrence avec d'autres produits** sans interférer avec eux.  
  **Exemple** : Un logiciel de messagerie qui fonctionne bien en parallèle avec un antivirus installé sans provoquer de conflits.

- **Interoperability (Interopérabilité)**  
  Vérifie si le produit peut **échanger des données ou interagir** avec d'autres systèmes ou applications.  
  **Exemple** : Une application de calendrier qui se synchronise automatiquement avec Google Calendar et Outlook.


### 4. **Usability (Utilisabilité)**
**Usability** mesure la facilité avec laquelle un utilisateur peut **utiliser** le produit, en prenant en compte l'efficacité, la satisfaction et l'expérience globale.

- **Appropriateness recognisability (Reconnaissance de l'adéquation)**  
  Vérifie si l'utilisateur peut **facilement comprendre** si le produit est adapté à ses besoins dès le début.  
  **Exemple** : Un tableau de bord d'application qui montre clairement les fonctionnalités principales dès la première utilisation.

- **Learnability (Apprendabilité)**  
  Vérifie si l'utilisateur peut **apprendre rapidement** à utiliser le produit sans difficulté pour accomplir des objectifs déterminées.  
  **Exemple** : Un logiciel de traitement de texte avec une interface simple et des outils de mise en forme faciles à comprendre.

- **Operability (Opérabilité)**  
  Vérifie si l'utilisateur peut **manipuler le produit facilement** et de manière fluide.  
  **Exemple** : Une application mobile avec des boutons clairement visibles et une navigation intuitive.

- **User error protection (Protection contre les erreurs de l'utilisateur)**  
  Vérifie si le produit offre des **mécanismes de protection** pour éviter les erreurs de l'utilisateur ou les corriger rapidement.  
  **Exemple** : Un formulaire en ligne qui avertit l'utilisateur lorsqu'il oublie de remplir un champ obligatoire.

- **User interface aesthetics (Esthétique de l'interface utilisateur)**  
  Vérifie si l'interface est **visuellement agréable** et si elle favorise une bonne expérience utilisateur.  
  **Exemple** : Une application avec un design épuré et moderne, des couleurs bien choisies et une disposition claire.

- **Accessibility (Accessibilité)**  
  Vérifie si le produit est **accessible** aux utilisateurs ayant des besoins spécifiques (par exemple, les personnes handicapées).  
  **Exemple** : Une application avec des options de contraste élevé et des lecteurs d'écran pour les utilisateurs malvoyants.


### 5. **Reliability (Fiabilité)**
**Reliability** évalue si le produit fonctionne de manière stable et cohérente dans le temps, sans défaillances.

- **Maturity (Maturité)**  
  évalue si le produit est **fiable** et a fait ses preuves dans des conditions réelles/normales d’utilisation.  
  **Exemple** : Un système d'exploitation qui est régulièrement mis à jour et ne subit pas de plantages fréquents.

- **Availability (Disponibilité)**  
  Vérifie si le produit est **disponible** et opérationnel quand l'utilisateur en a besoin.  
  **Exemple** : Un serveur web qui reste en ligne 24/7 sans interruptions majeures.

- **Fault tolerance (Tolérance aux pannes)**  
  Vérifie si le produit peut **continuer à fonctionner** même lorsqu'une partie de ses composants échoue.  
  **Exemple** : Un service cloud qui continue de fonctionner même si un de ses serveurs tombe en panne.

- **Recoverability (Récupérabilité)**  
  Vérifie si le produit peut **se remettre rapidement** d'une défaillance ou d'une erreur.  
  **Exemple** : Un système de base de données qui peut restaurer des données après une panne.

### 6. **Security (Sécurité)**
**Security** évalue si le produit protège les données et les utilisateurs contre les menaces et les accès non autorisés.

- **Confidentiality (Confidentialité)**  
  évalue si le produit garantit que les données ne sont accessibles qu'aux personnes autorisées à y accéder.
  **Exemple** : Un site de commerce en ligne qui crypte les informations de carte de crédit des utilisateurs.

- **Integrity (Intégrité)**  
  Vérifie si le produit protège les données contre toute **modification non autorisée** ou contre tous accès non autorisés .  
  **Exemple** : Un système bancaire qui empêche toute modification et accés des soldes de compte par des utilisateurs non autorisés.

- **Non-repudiation (Non-répudiation)**  
  Vérifie si le produit fournit des **preuves irréfutables** des actions effectuées par les utilisateurs.  
  **Exemple** : Un système de messagerie qui garde une trace de l'heure d'envoi de chaque message pour éviter toute contestation.

- **Accountability (Responsabilité)**  
  Vérifie si le produit permet de **suivre les actions des utilisateurs** et de leur attribuer la responsabilité.  
  **Exemple** : Un logiciel de gestion des accès qui enregistre toutes les connexions et actions des utilisateurs.

- **Authenticity (Authenticité)**  
  Vérifie si le produit peut **vérifier l'identité des utilisateurs** avant de leur accorder l'accès.  
  **Exemple** : Une application bancaire qui utilise une authentification à deux facteurs pour vérifier l'identité de l'utilisateur.

### 7. **Maintainability (Maintenabilité)**
**Maintainability** évalue la facilité avec laquelle le produit peut être **maintenu**, mis à jour et corrigé.

- **Modularity (Modularité)**  
  Vérifie si le produit est conçu de manière **modulaire**, facilitant les modifications et les mises à jour.  
  **Exemple** : Un système de gestion de contenu où chaque module (comme la gestion des utilisateurs ou des articles) peut être mis à jour indépendamment.

- **Reusability (Réutilisabilité)**  
  Vérifie si les composants du produit peuvent être **réutilisés** dans d'autres contextes ou projets.  
  **Exemple** : Une bibliothèque de fonctions en programmation qui peut être utilisée dans plusieurs projets différents.

- **Analyzability (Analyse)**  
  Vérifie si le produit permet de **diagnostiquer rapidement** les problèmes ou les erreurs.  
  **Exemple** : Un logiciel de serveur qui fournit des journaux d'erreurs détaillés pour faciliter le dépannage.

- **Modifiability (Modifiabilité)**  
  évalue si le produit peut être facilement **modifié** sans dégrader les autres fonctionnzlités .  
  **Exemple** : Si je vais changer le calcul de Montecarlo , je n'aurais qu' amlodifier la fonction calcul_MonteCarlo

- **Testability (Testabilité)**  
  Vérifie si le produit est conçu pour être **facilement testé** pour si des critères ont été respectés..
  **Exemple** : Un système d'exploitation avec des outils intégrés pour tester la stabilité et la sécurité des applications.

### 8. **Portability (Portabilité)**
**Portability** évalue la facilité avec laquelle le produit peut être **déplacé** ou **adapté** à d'autres environnements ou plateformes.

- **Adaptability (Adaptabilité)**  
  Vérifie si le produit peut être **adapté** facilement à de nouveaux environnements ou configurations.  
  **Exemple** : Une application mobile qui fonctionne sur plusieurs systèmes d'exploitation comme Android et iOS.

- **Installability (Installabilité)**  
  Vérifie si le produit peut être **installé ou désinstallé  facilement** sur différentes plateformes.  
  **Exemple** : Un logiciel qui peut être installé en quelques clics sur un ordinateur Windows, Mac et Linux.

- **Replaceability (Remplaçabilité)**  
  Vérifie si le produit peut être **remplacé** par une autre version ou par un autre produit sans perturber l’utilisation.  
  **Exemple** : Un systéme de messagerie qui en remplace un ancien en gardant la même basse de données.

## Les types d'utilisateurs

Les utilisateurs jouent un rôle central dans les quality in use (qualité en utilisation), car leurs interactions avec le produit déterminent comment le produit est perçu et comment il répond aux besoins réels dans des contextes d’utilisation variés.

### Utilisateurs principaux (Primary Users)
Ce sont les utilisateurs finaux qui interagissent directement avec le produit pour accomplir des tâches spécifiques et tirer de la valeur de son utilisation.
- **Exemple** : Un client d'une banque qui utilise l'application pour effectuer des virements et consulter son solde.

### Utilisateurs secondaires (Secondary Users)
Les utilisateurs secondaires soutiennent l'expérience des utilisateurs principaux en garantissant le bon fonctionnement du produit.
1. **Content Providers (Fournisseurs de contenu)**  
   Fournissent des fonctionnalités ou services nécessaires au produit, influençant sa **pertinence fonctionnelle** et sa **complétude fonctionnelle**.
    - **Exemple** : Les développeurs qui rajoutent une fonctionnalité de retrouver son mdp .
2. **Maintainers (Mainteneurs)**  
   Assurent la maintenance technique, garantissant la **fiabilité**, **disponibilité** et **sécurité** du produit.
    - **Exemple** : Un administrateur système qui veille à la stabilité de l'application bancaire.

### Utilisateurs indirects (Indirect Users)
Ce sont des parties prenantes qui ne sont pas directement impliquées dans l'utilisation du produit, mais qui en bénéficient ou financent son développement.
- **Exemple** : La banque qui a demandé aux développeurs de coder l'application bancaire.

## Quality in Use Measures

Les Quality in Use Measures (Mesures de qualité en usage) se réfèrent à l'évaluation de la performance d'un produit dans un contexte d'utilisation spécifique. Ces mesures sont utilisées pour évaluer dans quelle mesure un produit permet aux utilisateurs d'atteindre leurs objectifs dans un environnement donné.

es Quality in Use sont évaluées par des critères comme :

### **7.1 Effectiveness measures (Mesures d'efficacité)**
Les mesures d'efficacité évaluent la précision et l'exhaustivité avec lesquelles les utilisateurs atteignent les objectifs spécifiés. Elles se concentrent uniquement sur l'atteinte des objectifs, sans tenir compte de la manière dont ces objectifs ont été atteints.

1. **Task completion (Achèvement des tâches)**
  - **Description** : Proportion des tâches complétées correctement.
  - **Exemple** : Un utilisateur réussit à accomplir 80% des tâches assignées correctement.
  - **Méthode** : X = A/B, où A = nombre de tâches complétées, B = nombre total de tâches tentées.

2. **Task effectiveness (Efficacité des tâches)**
  - **Description** : Proportion des objectifs de la tâche atteints correctement.
  - **Exemple** : Lors d'une transaction bancaire, l'utilisateur atteint 90% des objectifs de la tâche, mais une petite erreur dans l'interface empêche l'envoi de la confirmation.
  - **Méthode** : X = 1 - ΣAi, où Ai est la valeur proportionnelle de chaque composant manquant ou incorrect dans le résultat de la tâche.

3. **Error frequency (Fréquence des erreurs)**
  - **Description** : Fréquence des erreurs commises par l'utilisateur par rapport à une valeur cible.
  - **Exemple** : Un utilisateur fait 5 erreurs sur 100 tentatives de transactions bancaires.
  - **Méthode** : X = A/B, où A = nombre d'erreurs commises, B = nombre de tâches ou de tentatives.

### **7.2 Efficiency measures (Mesures d'efficience)**
Les mesures d'efficience évaluent les ressources dépensées en relation avec la précision et l'exhaustivité avec lesquelles les utilisateurs atteignent leurs objectifs. La ressource la plus couramment mesurée est le temps nécessaire pour accomplir une tâche, mais d'autres ressources peuvent être prises en compte.

1. **Time (Temps)**
  - **Description** : Temps nécessaire pour accomplir une tâche comparé au temps cible.
  - **Exemple** : Une tâche qui devrait prendre 5 minutes prend en réalité 7 minutes.
  - **Méthode** : X = TT/ta , où Tt = temps cible, Ta = temps réel.

2. **Relative task time (Temps relatif de la tâche)**
  - **Description** : Temps qu'un utilisateur met pour accomplir une tâche comparé à un expert.
  - **Exemple** : Un utilisateur ordinaire met 10 minutes pour accomplir une tâche, tandis qu'un expert la termine en 5 minutes.
  - **Méthode** : X = B / A, où A = temps de l'utilisateur ordinaire, B = temps de l'expert.

3. **Task efficiency (Efficience des tâches)**
  - **Description** : Efficacité avec laquelle un utilisateur accomplit une tâche.
  - **Exemple** : Un utilisateur termine une tâche en 10 minutes avec 90% de réussite.
  - **Méthode** : X = M1 / T, où M1 = efficacité de la tâche, T = temps de la tâche.

4. **Relative task efficiency (Efficience relative de la tâche)**
  - **Description** : Efficacité d'un utilisateur comparée à un objectif ou à un expert.
  - **Exemple** : Un utilisateur accomplit une tâche avec une efficacité de 80%, alors que l'efficacité cible est de 100%.
  - **Méthode** : X = A / B, où A = efficacité de l'utilisateur ordinaire, B = efficacité cible.

5. **Economic productivity (Productivité économique)**
  - **Description** : Coût pour l'utilisateur pour accomplir une tâche par rapport à l'efficacité de la tâche.
  - **Exemple** : L'utilisateur passe 5 minutes et dépense 1€ pour accomplir une tâche, avec une efficacité de 80%.
  - **Méthode** : X = M1 / C, où M1 = efficacité de la tâche, C = coût total de la tâche.

6. **Productive proportion (Proportion productive)**
  - **Description** : Proportion du temps où l'utilisateur effectue des actions productives.
  - **Exemple** : L'utilisateur passe 20 minutes sur une tâche, dont 15 minutes sont productives.
  - **Méthode** : X = Ta / Tb, où Ta = temps productif, Tb = temps total de la tâche.

7. **Relative number of user actions (Nombre relatif d'actions de l'utilisateur)**
  - **Description** : Nombre d'actions effectuées par l'utilisateur comparé au nombre d'actions nécessaires.
  - **Exemple** : Un utilisateur effectue 12 actions pour accomplir une tâche, alors que seulement 10 actions sont nécessaires.
  - **Méthode** : X = A / B, où A = nombre d'actions effectuées, B = nombre d'actions nécessaires.

### 7.3 Satisfaction : Mesure la satisfaction générale des utilisateurs à propos de l'usage du produit.

