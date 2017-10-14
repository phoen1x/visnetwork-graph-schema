# Quickstart
```bash
# start Neo4j database - https://hub.docker.com/_/neo4j/
docker run -ti --rm  \
            -p 7474:7474 \
            -p 7687:7687 \
            --env=NEO4J_AUTH=none \
            neo4j
            
# import some data --- https://neo4j.com/graphgist/organization-learning

# run project
git clone https://github.com/phoen1x/visnetwork-graph-schema.git
Rscript visnetwork-graph-schema/scripts/Template.R

# open result in web browser
firefox /tmp/network.html
```

# Usage
[read my article](http://www.livingfire.de/proggen/neo4j-graph-schema-visualization-with-netviz-en/)

# Based on
* [Text Tutorial - Nicole White](https://nicolewhite.github.io/2015/06/18/visualize-your-graph-with-rneo4j-and-visNetwork.html)
* [Video Tutorial - Nicole White](https://www.youtube.com/watch?v=bdQ90y9Pefo)

# Further reading
* [Graph Visualization for Neo4j Schemas](https://neo4j.com/blog/graph-visualization-neo4j-schemas-yfiles/)
* [visNetwork](http://datastorm-open.github.io/visNetwork/)
