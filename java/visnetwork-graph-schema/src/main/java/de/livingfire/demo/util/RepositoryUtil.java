package de.livingfire.demo.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.neo4j.ogm.annotation.Relationship;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.annotation.AnnotationUtils;

import de.livingfire.demo.constant.DotNotationConstant;

public class RepositoryUtil implements DotNotationConstant {

    public Map<String, DotNotation> getNodeRelations(String rootPackage) {
        Map<String, DotNotation> nodeRelations = new HashMap<>();

        final ClassPathScanningCandidateComponentProvider provider = new RepositoryComponentProvider(false);
        provider.findCandidateComponents(rootPackage)
                .stream()
                .map(beanDefinition -> addRepository(beanDefinition))
                .flatMap(List::stream)
                .forEach(dotNotation -> nodeRelations.put(DotNotationPrinter.format(dotNotation), dotNotation));

        return nodeRelations;
    }

    private List<DotNotation> addRepository(BeanDefinition beanDefinition) {
        Class<?> repositoryClass = getClassByName(beanDefinition.getBeanClassName());
        Class<?> rootNodeClass = getClassRepository(repositoryClass);
        printRepositoryPath(repositoryClass);
        return getDotNotations(rootNodeClass);
    }

    private List<DotNotation> getDotNotations(Class<?> rootNodeClass) {
        return Arrays.asList(rootNodeClass.getDeclaredFields())
                     .stream()
                     .filter(field -> field.isAnnotationPresent(Relationship.class))
                     .map(field -> getDotNotation(rootNodeClass.getSimpleName(), field))
                     .collect(Collectors.toList());
    }

    public DotNotation getDotNotation(String from,
                                      Field field) {
        String to = field.getGenericType()
                         .getTypeName()
                         .replaceAll(".*\\.", "")
                         .replaceAll(">", "");

        Annotation annotation = field.getAnnotation(Relationship.class);
        String direction = AnnotationUtils.getValue(annotation, "direction")
                                          .toString();

        if (Relationship.INCOMING.equals(direction)) {
            return new DotNotation(to, from, getDotNotationAttributes(annotation));
        }
        return new DotNotation(from, to, getDotNotationAttributes(annotation));
    }

    public Map<String, String> getDotNotationAttributes(Annotation annotation) {
        String type = AnnotationUtils.getValue(annotation, "type")
                                     .toString();
        return Collections.unmodifiableMap(
                Stream.of(new SimpleEntry<>(ATTRIBUTE_LABEL, type))
                      .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue())));

    }

    public Class<?> getClassByName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("wtf?", e);
        }
    }

    public Class<?> getClassRepository(Class<?> clazz) {
        String className = ((ParameterizedType) clazz.getGenericInterfaces()[0]).getActualTypeArguments()[0].getTypeName();
        return getClassByName(className);
    }

    private void printRepositoryPath(Class<?> clazz) {
        Annotation annotation = RepositoryComponentProvider.filterRepositoryAnnotation(clazz.getAnnotations());
        String path = AnnotationUtils.getValue(annotation, "path")
                                     .toString();
        System.out.println(String.format("found path: %s", path));
    }

}
