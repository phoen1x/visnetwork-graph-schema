package de.livingfire.demo.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.util.StringUtils;

public class DotNotationPrinterTest {

    @Test
    public void testFormatNoAtributes() throws Exception {
        DotNotation dotNotation = new DotNotation("from", "to");
        String actual = DotNotationPrinter.format(dotNotation);
        assertThat(actual).isEqualTo("from -> to;");
    }

    @Test
    public void testFormatOneAtributes() throws Exception {
        Map<String, String> attributes = new HashMap<>();
        attributes.put("label", "foo");

        DotNotation dotNotation = new DotNotation("from", "to", attributes);
        String actual = DotNotationPrinter.format(dotNotation);
        assertThat(actual).isEqualTo("from -> to [label=foo];");
    }

    @Test
    public void testFormatManyAtributes() throws Exception {
        Map<String, String> attributes = new HashMap<>();
        attributes.put("label1", "foo1");
        attributes.put("label2", "foo2");
        attributes.put("label3", "foo3");

        DotNotation dotNotation = new DotNotation("from", "to", attributes);
        String actual = DotNotationPrinter.format(dotNotation);
        assertThat(actual).isEqualTo("from -> to [label1=foo1 label2=foo2 label3=foo3];");
    }

    @Test
    public void testSnippetGraphOverviewString() throws Exception {
        String actual = DotNotationPrinter.snippetGraphOverview("de.livingfire.demo");
        Files.write(Paths.get("target/snippetGraphOverview.html"), actual.getBytes());
        assertThat(StringUtils.countOccurrencesOf(actual, "DOTstring +=")).isEqualTo(10);
    }

    @Test
    public void testFormatJs() throws Exception {
        Map<String, String> attributes = new HashMap<>();
        attributes.put("label", "foo");

        DotNotation dotNotation = new DotNotation("from", "to", attributes);
        String actual = DotNotationPrinter.formatJs(dotNotation);
        assertThat(actual).isEqualTo("    DOTstring +=    '    from -> to [label=foo];'");
    }
}
