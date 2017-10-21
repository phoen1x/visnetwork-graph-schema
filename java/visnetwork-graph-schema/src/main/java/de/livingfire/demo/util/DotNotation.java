package de.livingfire.demo.util;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class DotNotation {

    private String from;
    private String to;
    private Map<String, String> attributes;

    public DotNotation(String from,
                       String to) {
        super();
        this.from = from;
        this.to = to;
        this.attributes = new HashMap<>();
    }

    public DotNotation(String from,
                       String to,
                       Map<String, String> attributes) {
        super();
        this.from = from;
        this.to = to;
        this.attributes = attributes;
        if (attributes == null) {
            this.attributes = new HashMap<>();
        }
    }

}
