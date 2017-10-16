# http://datastorm-open.github.io/visNetwork/
library(visNetwork)

# https://github.com/nicolewhite/RNeo4j
library(RNeo4j)

# connect to database
graph <- startGraph("http://localhost:7474/db/data/")
# graph <- startGraph("http://localhost:7474/db/data/", username="neo4j", password="neo4j")

# https://nicolewhite.github.io/2015/06/18/visualize-your-graph-with-rneo4j-and-visNetwork.html
node_query <- "
CALL db.labels() YIELD label
RETURN label as id, label, label as group
ORDER BY label
"

edge_query <- "
MATCH (n)-[r]->(m)
RETURN distinct
      labels(n)[0] as from
    , labels(m)[0] as to
    , type(r) as label
    , type(r) as title
"

# get neo4j data
nodes <- cypher(graph, node_query)
edges <- cypher(graph, edge_query)

# calculate the graph
network <-
    visNetwork(nodes,
               edges,
               main = "Neo4j graph schema",
               height = "700px",
               width = "100%") %>%
    visOptions(
        highlightNearest = list(enabled = TRUE, hover = TRUE),
        nodesIdSelection = TRUE
    ) %>%
    visNodes(shape = "ellipse",
             shadow = list(enabled = TRUE, size = 10)) %>%
    visEdges(
        shadow = TRUE,
        arrows = list(to = list(enabled = TRUE)),
        color = list(color = "lightblue", highlight = "red")
    ) %>%
    visInteraction(hover = TRUE, hoverConnectedEdges = TRUE) %>%
    visLegend(width = 0.1,
              position = "right",
              main = "Type") %>%
    visLayout(randomSeed = 12)  %>%
    visPhysics(solver = "forceAtlas2Based",
               forceAtlas2Based = list(gravitationalConstant = -200))

# plot the graph
network

# save as HTML
visSave(network, file = "/scripts/output/Docker.html")
# visSave(network, file = "C:/network.html")
