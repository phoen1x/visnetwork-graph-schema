package de.livingfire.demo.util;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public class RepositoryComponentProvider extends ClassPathScanningCandidateComponentProvider {

    public RepositoryComponentProvider(boolean useDefaultFilters) {
        super(useDefaultFilters);
        this.addIncludeFilter(new RegexPatternTypeFilter(Pattern.compile(".*")));
    }

    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        Class<?> clazz;
        try {
            clazz = Class.forName(beanDefinition.getBeanClassName());
            return isCandidateComponent(clazz);
        } catch (Exception e) {
            throw new RuntimeException("wtf?", e);
        }
    }

    public boolean isCandidateComponent(Class<?> clazz) {
        return filterRepositoryAnnotation(clazz.getAnnotations()) != null;
    }

    public static Annotation filterRepositoryAnnotation(Annotation[] annotations) {
        return Arrays.asList(annotations)
                     .stream()
                     .filter(
                             annotation -> RepositoryRestResource.class.getName()
                                                                       .equals(
                                                                               annotation.annotationType()
                                                                                         .getName()))
                     .findFirst()
                     .orElse(null);
    }
}