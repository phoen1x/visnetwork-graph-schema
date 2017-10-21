package de.livingfire.demo.repository;

import java.util.List;

import org.neo4j.ogm.annotation.Relationship;

public class Foo {
    @Relationship(type = "PROVIDES",
            direction = Relationship.INCOMING)
    private List<Bar> bars;
}
