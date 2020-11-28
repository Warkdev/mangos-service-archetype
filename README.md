# Mangos-service-archetype

This project is a maven template used to generate the maven archetype to develop Mangos REST API Services.

# How to use it ?

Some simple steps, clone the repo, install the maven package and generate a project based on it !

```sh
# First, install the archetype
git clone https://github.com/Warkdev/mangos-service-archetype.git/
cd mangos-service-archetype
mvn install

# Then, create a new project, here item-service as an example.
cd..
mvn archetype:generate -B "-DarchetypeGroupId=eu.getmangos" "-DarchetypeArtifactId=mangos-service-template-archetype" "-DarchetypeVersion=1.0" "-DartifactId=item-service" "-DmainEntity=Item" "-DpersistenceUnits=WORLD,DBC"

# This will create a new folder item-service and generate the basic skeleton around the entity 'Item'
```

Note that you have some default maven properties:

```yaml
groupId: eu.getmangos
version: 1.0
mainEntity: Test
persistenceUnits: AUTH, CHAR, WORLD, DBC # This has an effect on generated server.xml, <MainEntity>Controller.java and persistence.xml
```