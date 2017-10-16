# http://datastorm-open.github.io/visNetwork/
library(visNetwork)

# https://github.com/nicolewhite/RNeo4j
library(RNeo4j)

# connect to database
graph <- startGraph("http://localhost:7474/db/data/")
# graph <- startGraph("http://localhost:7474/db/data/", username="neo4j", password="neo4j")

# https://nicolewhite.github.io/2015/06/18/visualize-your-graph-with-rneo4j-and-visNetwork.html
node_query <- "
MATCH (n)
WHERE n.name in ['Alice','Bob','Express train','Subway','Ticket Zone1','Ticket Zone3','First Class Travel','Station North']
RETURN  n.name as id
      , n.name as label
      , labels(n)[0] as group
"

edge_query <- "
MATCH (n:Person)-[r]->(m)
WHERE n.name IN ['Alice','Bob']
RETURN
      n.name as from
    , m.name as to
    , type(r) as label
    , type(r) as title
UNION
MATCH (n:Ticket{name:'First Class Travel'})-[r]->(m:Ticket{name:'Ticket Zone3'})
RETURN
      n.name as from
    , m.name as to
    , type(r) as label
    , type(r) as title
UNION
MATCH (n:Train)-[r]->(m:Station{name:'Station North'})
RETURN
      n.name as from
    , m.name as to
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
               main = "Sample: First Class Travel",
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
    visGroups(groupname = "Person", color = "#FFFB4F") %>%
    visGroups(groupname = "Station", color = "#FF7D81") %>%
    visGroups(groupname = "Ticket", color = "#69DD5B") %>%
    visGroups(groupname = "Train", color = "#F382ED") %>%
    visLayout(randomSeed = 12)  %>%
    visPhysics(solver = "forceAtlas2Based",
               forceAtlas2Based = list(gravitationalConstant = -80))

# plot the graph
network

# save as HTML
visSave(network, file = "/scripts/output/DockerSampleData.html")
# visSave(network, file = "C:/network.html")
