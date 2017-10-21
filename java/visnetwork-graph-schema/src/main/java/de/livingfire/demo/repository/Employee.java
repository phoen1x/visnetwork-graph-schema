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
public class Employee {

    @GraphId
    private Long id;

    private String name;

    @Relationship(type = "INSPECTS_TICKET",
            direction = Relationship.OUTGOING)
    private List<Person> persons;

    @Relationship(type = "DRIVES",
            direction = Relationship.OUTGOING)
    private Train tainDriven;

    @Relationship(type = "REPAIRS",
            direction = Relationship.OUTGOING)
    private Train tainRepair;
}
