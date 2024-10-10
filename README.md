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
