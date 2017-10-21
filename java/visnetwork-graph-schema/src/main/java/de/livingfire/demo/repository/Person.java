package de.livingfire.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;

@Data
@NodeEntity
public class Person {

    @GraphId
    private Long id;

    private String name;

    @Relationship(type = "USES",
            direction = Relationship.OUTGOING)
    private Train trains;

    @Relationship(type = "USES",
            direction = Relationship.OUTGOING)
    private Station stations;

    @Relationship(type = "BUYS",
            direction = Relationship.OUTGOING)
    private List<Ticket> tickets;

    public Person() {
        super();
        this.tickets = new ArrayList<>();
    }
}
