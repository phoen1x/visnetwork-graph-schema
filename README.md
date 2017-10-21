# Quickstart
```bash
# start Neo4j database - https://hub.docker.com/_/neo4j/
docker run -ti --rm  \
            -p 7474:7474 \
            -p 7687:7687 \
            --env=NEO4J_AUTH=none \
            phoen1x/visnetwork-graph-schema

# run R-Script
git clone https://github.com/phoen1x/visnetwork-graph-schema.git
Rscript visnetwork-graph-schema/scripts/Template.R

# open result in web browser
firefox /tmp/network.html
```

# Run R inside Docker

Make sure you have a working [Docker](https://docs.docker.com/engine/installation/), [docker-compose](https://docs.docker.com/compose/install/) and [Git](https://git-scm.com/downloads) environment.

```bash
# download project
git clone https://github.com/phoen1x/visnetwork-graph-schema.git

# start container
cd visnetwork-graph-schema/docker
docker-compose up -d

# WAIT A FEW SECONDS for Neo4j to boot then run R-Scripts
docker-compose exec neo4j Rscript /scripts/Docker.R

# view results in web browser
firefox ../scripts/output/Docker.html

# stop container
docker-compose down
```

# Import your database via CSV
```bash
# navigate to docker folder
PROJECT="/tmp/visnetwork-graph-schema/docker"
cd $PROJECT/docker

# name,email,username
# Alice,alice,"alice@example.local"
# Bob,bob,"bob@example.local"
atom /tmp/foo.csv

# copy data from local file system
docker cp /tmp/foo.csv visnetwork_neo4j_1:/import/foo.csv
```

## Drop demo database
```cypher
MATCH (n)
DETACH DELETE n
```

## Import data
```cypher
// https://neo4j.com/blog/importing-data-neo4j-via-csv/
LOAD CSV WITH HEADERS FROM "file:///foo.csv" AS csvLine FIELDTERMINATOR ','
MERGE (u:User { name: csvLine.name, username: csvLine.username, email: csvLine.email });
```

# Import your database via Cypher DUMP
```bash
# overwrite initial-database.cql
PROJECT="/tmp/visnetwork-graph-schema/docker"
cat /tmp/my_dump.cql > $PROJECT/docker/initial-database.cql

# set docker-compose.yml into build mode
# replace 'image: ...' with 'build .'
sed -i 's|image:.*|build: .|' docker-compose.yml

# start in debug mode
docker-compose up --build && docker-compose down
```

# Usage
* [read documentation](http://www.livingfire.de/proggen/neo4j-graph-schema-visualization-with-netviz-en/)

# Based on
* [Text Tutorial - Nicole White](https://nicolewhite.github.io/2015/06/18/visualize-your-graph-with-rneo4j-and-visNetwork.html)
* [Video Tutorial - Nicole White](https://www.youtube.com/watch?v=bdQ90y9Pefo)

# Further reading
* [vis.js](http://visjs.org/)
* [visNetwork](http://datastorm-open.github.io/visNetwork/)
* [Graph Visualization for Neo4j Schemas](https://neo4j.com/blog/graph-visualization-neo4j-schemas-yfiles/)
