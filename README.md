# Kafka Architecture

## Introduction
Kafka est une plateforme de streaming distribuée qui permet de publier, stocker, traiter et consommer des flux de données en temps réel. Ce projet explore la structure de Kafka, en mettant l'accent sur les **Streams**, **Topics**, et **Partitions**, ainsi que sur la manière de créer des producteurs et consommateurs Kafka via la ligne de commande (CLI).

## Streams
Un **Stream d'événements** est un flux continu d'événements interconnectés et liés qui évoluent dynamiquement au fil du temps. Cela est particulièrement utile dans le traitement des données en temps réel et les architectures pilotées par les événements.

## Topics
Un **Topic** dans Kafka est une catégorie ou un flux d'événements auxquels les producteurs publient des messages et que les consommateurs lisent. Les Topics sont essentiels pour organiser et traiter les messages en fonction de leurs objectifs.

## Partitions
Une **Partition** est la plus petite unité de stockage dans un Topic. Chaque partition contient un sous-ensemble d'enregistrements, ce qui permet la distribution parallèle des données et la scalabilité de Kafka. Une partition peut être assignée à un ou plusieurs consommateurs pour un traitement simultané.

## Commandes Kafka CLI

### Créer un Topic
Vous pouvez créer un nouveau Topic dans Kafka à l'aide de la commande suivante :
```bash
bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test


Voici un fichier `README.md` formaté avec les commandes Kafka que vous avez partagées :

```md
# Kafka Command Line Interface (CLI) Guide

## Introduction
Ce guide présente les principales commandes Kafka à utiliser via la ligne de commande (CMD) pour la gestion des Topics, des Producteurs et des Consommateurs, ainsi que la gestion des clusters Kafka. Vous trouverez ci-dessous des exemples de commandes pour chacune des opérations courantes.

## Prérequis
Avant d'utiliser ces commandes, assurez-vous d'avoir démarré Kafka et Zookeeper sur votre machine. Utilisez ces commandes pour lancer les services :

```bash
bin/zookeeper-server-start.sh config/zookeeper.properties
bin/kafka-server-start.sh config/server.properties
```

## Commandes Kafka

### 1. Gestion des Topics

#### Créer un Topic
Crée un Topic avec un facteur de réplication et un nombre de partitions définis :

```bash
bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic <nom_du_topic>
```

#### Lister les Topics
Liste tous les Topics disponibles sur le serveur Kafka :

```bash
bin/kafka-topics.sh --list --bootstrap-server localhost:9092
```

#### Décrire un Topic
Affiche des informations sur un Topic particulier (comme les partitions et les réplicas) :

```bash
bin/kafka-topics.sh --describe --bootstrap-server localhost:9092 --topic <nom_du_topic>
```

#### Supprimer un Topic
Supprime un Topic existant (s'il est activé sur le serveur) :

```bash
bin/kafka-topics.sh --delete --bootstrap-server localhost:9092 --topic <nom_du_topic>
```

### 2. Gestion des Producteurs et Consommateurs

#### Créer un Producteur
Démarre un Producteur Kafka qui envoie des messages à un Topic :

```bash
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic <nom_du_topic>
```

#### Créer un Consommateur
Démarre un Consommateur Kafka qui lit les messages d'un Topic :

```bash
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic <nom_du_topic> --from-beginning
```

#### Consommer des messages depuis un Group ID spécifique
Lance un Consommateur Kafka en précisant un group ID (utile pour la gestion des offsets) :

```bash
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic <nom_du_topic> --group <nom_du_groupe>
```

### 3. Gestion des Offsets

#### Vérifier les offsets d'un consommateur
Affiche la position actuelle du consommateur dans le Topic et sa position d'offset :

```bash
bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group <nom_du_groupe>
```

#### Réinitialiser les offsets
Réinitialise les offsets d'un consommateur à un point précis (utile pour des cas de replay) :

```bash
bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --reset-offsets --group <nom_du_groupe> --topic <nom_du_topic> --to-earliest --execute
```

### 4. Autres commandes utiles

#### Vérifier l'état du cluster Kafka
Affiche des informations sur l'état général du cluster Kafka :

```bash
bin/kafka-broker-api-versions.sh --bootstrap-server localhost:9092
```

#### Afficher les métriques du serveur Kafka
Affiche les métriques sur le serveur Kafka et les performances du cluster :

```bash
bin/kafka-run-class.sh kafka.tools.JmxTool --reporting-interval 1000 --jmx-url service:jmx:rmi:///jndi/rmi://localhost:9999/jmxrmi
```

### 5. Commandes pour Zookeeper

#### Lister les brokers dans Zookeeper
Lance une session shell Zookeeper pour lister les brokers Kafka connectés :

```bash
bin/zookeeper-shell.sh localhost:2181
ls /brokers/ids
```

#### Arrêter Zookeeper
Pour arrêter le service Zookeeper :

```bash
bin/zookeeper-server-stop.sh
```

## Conclusion
Ce guide contient les commandes essentielles pour gérer Kafka via la ligne de commande. Que ce soit pour créer des Topics, interagir avec des producteurs ou des consommateurs, ou gérer les offsets, ces commandes vous aideront à interagir efficacement avec un cluster Kafka.
```

Tu peux l'ajouter à ton projet ou adapter selon tes besoins !
