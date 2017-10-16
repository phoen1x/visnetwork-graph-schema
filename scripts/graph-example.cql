// Author: Thomas Lutz
// URL: http://www.livingfire.de/proggen/neo4j-graph-schema-visualization-with-netviz-en/
// GitHub: https://github.com/phoen1x/livingfire-uml
// GitHub: https://github.com/phoen1x/visnetwork-graph-schema

// MATCH (n) DETACH DELETE n

CREATE (person1:Person {name:"Alice"})
CREATE (person2:Person {name:"Bob"})
CREATE (person3:Person {name:"Charlie"})

CREATE (employee1:Employee {name:"Driver"})
CREATE (employee2:Employee {name:"Mechanic"})
CREATE (employee3:Employee {name:"Inspector"})

CREATE (train1:Train {name:"Express train"})
CREATE (train2:Train {name:"Subway"})

CREATE (ticket1:Ticket {name:"Ticket Zone1"})
CREATE (ticket2:Ticket {name:"Ticket Zone2"})
CREATE (ticket3:Ticket {name:"Ticket Zone3"})
CREATE (ticket4:Ticket {name:"First Class Travel"})

CREATE (station1:Station {name:"Station North"})
CREATE (station2:Station {name:"Station South"})
CREATE (station3:Station {name:"Station West"})
CREATE (station4:Station {name:"Station East"})

CREATE (person1)-[:USES]->(train1)
CREATE (person2)-[:USES]->(train2)
CREATE (person3)-[:USES]->(train2)

CREATE (person1)-[:USES]->(station1)
CREATE (person1)-[:USES]->(station3)
CREATE (person2)-[:USES]->(station1)
CREATE (person3)-[:USES]->(station2)

CREATE (person1)-[:BUYS]->(ticket3)
CREATE (person1)-[:BUYS]->(ticket4)
CREATE (person2)-[:BUYS]->(ticket1)
CREATE (person3)-[:BUYS]->(ticket2)

CREATE (ticket4)-[:REQUIRES]->(ticket1)
CREATE (ticket4)-[:REQUIRES]->(ticket2)
CREATE (ticket4)-[:REQUIRES]->(ticket3)

CREATE (station1)-[:NEXT_STATION]->(station2)
CREATE (station2)-[:NEXT_STATION]->(station3)
CREATE (station3)-[:NEXT_STATION]->(station4)
CREATE (station4)-[:NEXT_STATION]->(station1)

CREATE (station1)-[:PROVIDES]->(ticket1)
CREATE (station1)-[:PROVIDES]->(ticket2)
CREATE (station1)-[:PROVIDES]->(ticket3)
CREATE (station1)-[:PROVIDES]->(ticket4)
CREATE (station2)-[:PROVIDES]->(ticket1)
CREATE (station2)-[:PROVIDES]->(ticket2)
CREATE (station2)-[:PROVIDES]->(ticket3)
CREATE (station2)-[:PROVIDES]->(ticket4)
CREATE (station3)-[:PROVIDES]->(ticket1)
CREATE (station3)-[:PROVIDES]->(ticket2)
CREATE (station3)-[:PROVIDES]->(ticket3)
CREATE (station3)-[:PROVIDES]->(ticket4)
CREATE (station4)-[:PROVIDES]->(ticket1)
CREATE (station4)-[:PROVIDES]->(ticket2)
CREATE (station4)-[:PROVIDES]->(ticket3)
CREATE (station4)-[:PROVIDES]->(ticket4)

CREATE (train1)-[:ARRIVES]->(station1)
CREATE (train1)-[:ARRIVES]->(station3)
CREATE (train2)-[:ARRIVES]->(station1)
CREATE (train2)-[:ARRIVES]->(station2)
CREATE (train2)-[:ARRIVES]->(station3)
CREATE (train2)-[:ARRIVES]->(station4)

CREATE (employee1)-[:DRIVES]->(train2)
CREATE (employee2)-[:REPAIRS]->(train1)
CREATE (employee3)-[:INSPECTS_TICKET]->(person2)
CREATE (employee3)-[:INSPECTS_TICKET]->(person3)
