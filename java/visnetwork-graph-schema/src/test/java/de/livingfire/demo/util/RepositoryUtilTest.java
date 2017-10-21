package de.livingfire.demo.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.lang.reflect.Field;
import java.util.Map;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import de.livingfire.demo.repository.Foo;
import de.livingfire.demo.repository.Person;

@RunWith(MockitoJUnitRunner.class)
public class RepositoryUtilTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private RepositoryUtil util;

    @Before
    public void setUp() {
        util = new RepositoryUtil();
    }

    @Test
    public void testGetNodeRelations() throws Exception {
        Map<String, DotNotation> dotNotations = new RepositoryUtil().getNodeRelations("de.livingfire.demo");
        assertThat(dotNotations).hasSize(9);
    }

    @Test
    public void testGetDotNotationOutgoing() throws Exception {
        String from = Person.class.getSimpleName();
        Field field = Person.class.getDeclaredField("trains");

        DotNotation actual = util.getDotNotation(from, field);
        assertThat(DotNotationPrinter.format(actual)).isEqualTo("Person -> Train [label=USES];");
    }

    @Test
    public void testGetDotNotationIncomming() throws Exception {
        String from = Foo.class.getSimpleName();
        Field field = Foo.class.getDeclaredField("bars");

        DotNotation actual = util.getDotNotation(from, field);
        assertThat(DotNotationPrinter.format(actual)).isEqualTo("Bar -> Foo [label=PROVIDES];");
    }

    @Test
    public void testGetClassByName() throws Exception {
        try {
            util.getClassByName("FooBar");
            fail("Exception expected");
        } catch (Throwable e) {
            this.thrown.expect(RuntimeException.class);
            this.thrown.expectMessage("wtf?");
            throw e;
        }
    }

}
