package de.livingfire.demo.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.Mockito.doThrow;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;

import de.livingfire.demo.repository.Person;
import de.livingfire.demo.repository.PersonRepository;

@RunWith(MockitoJUnitRunner.class)
public class RepositoryComponentProviderTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Mock
    private AnnotatedBeanDefinition beanDefinition;

    private RepositoryComponentProvider service;

    @Before
    public void setUp() {
        service = new RepositoryComponentProvider(false);
    }

    @Test
    public void testIsCandidateComponentClassNotFoundShouldThrowRuntimeException() throws Exception {
        doThrow(ClassNotFoundException.class).when(beanDefinition)
                                             .getBeanClassName();

        try {
            service.isCandidateComponent(beanDefinition);
            fail("Exception expected");
        } catch (Throwable e) {
            this.thrown.expect(RuntimeException.class);
            this.thrown.expectMessage("wtf?");
            throw e;
        }
    }

    @Test
    public void testIsCandidateComponentHasAnnotationShouldReturnTrue() throws Exception {
        boolean actual = service.isCandidateComponent(PersonRepository.class);
        assertThat(actual).isTrue();
    }

    @Test
    public void testIsCandidateComponentNoAnnotationShouldReturnFalse() throws Exception {
        boolean actual = service.isCandidateComponent(Person.class);
        assertThat(actual).isFalse();
    }

}
