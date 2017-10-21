package de.livingfire.demo.repository;

import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@NodeEntity
public class Train {

    @GraphId
    private Long id;

    private String name;

    @Relationship(type = "ARRIVES",
            direction = Relationship.OUTGOING)
    private List<Station> stations;
}
