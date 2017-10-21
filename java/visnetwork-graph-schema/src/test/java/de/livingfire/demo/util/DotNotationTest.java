package de.livingfire.demo.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.junit.Test;

public class DotNotationTest {

    @Test
    public void testDotNotationStringStringNullShouldHaveEmptyList() throws Exception {
        DotNotation actual = new DotNotation("from", "to", null);
        assertThat(actual.getAttributes()).isNotNull();
        assertThat(actual.getAttributes()).hasSize(0);
    }

    @Test
    public void testDotNotationStringStringAttributesSouldHaveAttributes() throws Exception {
        Map<String, String> attributes = new HashedMap<>();
        attributes.put("key", "value");

        DotNotation actual = new DotNotation("from", "to", attributes);
        assertThat(actual.getAttributes()).isNotNull();
        assertThat(actual.getAttributes()).hasSize(1);
        assertThat(
                actual.getAttributes()
                      .get("key")).isEqualTo("value");
    }

    @Test
    public void testDotNotationStringString() throws Exception {
        DotNotation actual = new DotNotation("from", "to");
        assertThat(actual.getAttributes()).isNotNull();
        assertThat(actual.getAttributes()).hasSize(0);
    }
}
