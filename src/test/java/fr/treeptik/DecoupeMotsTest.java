package fr.treeptik;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DecoupeMotsTest {

    @Parameterized.Parameter(value = 0)
    public String input;

    @Parameterized.Parameter(value = 1)
    public List<String> output;

    @Parameterized.Parameters(name = "{index}: decoupeMots({0} = {1}")
    public static Collection<Object[]> params() {
        return Arrays.asList(
                new Object[] { "", new ArrayList<String>()},
                new Object[] { "foo bar", Arrays.asList("foo", "bar")},
                new Object[] { "foo     bar", Arrays.asList("foo", "bar")},
                new Object[] { "foo  !! ? bar", Arrays.asList("foo", "bar")},
                new Object[] { "foo, bar", Arrays.asList("foo", "bar")},
                new Object[] { "foo, bar !bar", Arrays.asList("foo", "bar", "bar")}
        );
    }

    @Test
    public void testDecoupageMots() {
        CompteurMot compteurMot = new CompteurMot();
        List mots = compteurMot.decouper(input);
        assertEquals(output, mots);
    }
}
