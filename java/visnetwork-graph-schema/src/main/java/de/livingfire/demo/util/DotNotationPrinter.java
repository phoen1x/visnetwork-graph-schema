package de.livingfire.demo.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class DotNotationPrinter {

    private static final String DIRECTION_OUTGOING = " -> ";

    private DotNotationPrinter() {
        super();
    }

    public static String format(DotNotation dotNotation) {
        StringBuilder builder = new StringBuilder();
        builder.append(dotNotation.getFrom())
               .append(DIRECTION_OUTGOING)
               .append(dotNotation.getTo());
        if (dotNotation.getAttributes()
                       .size() > 0) {
            builder.append(" [");
            builder.append(
                    dotNotation.getAttributes()
                               .keySet()
                               .stream()
                               .map(
                                       k -> k + "=" + dotNotation.getAttributes()
                                                                 .get(k))
                               .collect(Collectors.joining(" ")));
            builder.append("]");
        }
        builder.append(";");
        return builder.toString();
    }

    public static String formatJs(DotNotation dotNotation) {
        return "    DOTstring +=    '    " + format(dotNotation) + "'";
    }

    public static String formatJsDotStringVariable(Set<String> dotNotations) {
        StringBuilder builder = new StringBuilder().append("    // provide data in the DOT language\n")
                                                   .append("        var DOTstring = 'mynetwork {';\n");
        dotNotations.stream()
                    .sorted()
                    .forEach(
                            e -> builder.append("        DOTstring +=    '    ")
                                        .append(e)
                                        .append("';\n"));
        return builder.append("        DOTstring +=    '}'\n")
                      .toString();
    }

    public static String snippetGraphOverview(String rootPackage) throws IOException {
        return snippetGraphOverview(new RepositoryUtil().getNodeRelations(rootPackage));
    }

    public static String snippetGraphOverview(Map<String, DotNotation> dotNotations) throws IOException {
        String jsDotStringVariable = DotNotationPrinter.formatJsDotStringVariable(dotNotations.keySet());
        return new String(
                Files.readAllBytes(Paths.get("src/test/resources/template.html"))).replace(
                        "    // provide data in the DOT language",
                            jsDotStringVariable)
                                                                                  .replaceAll(
                                                                                          "My Network",
                                                                                              "Your Neo4j database state --- "
                                                                                                      + new Date());
    }
}
