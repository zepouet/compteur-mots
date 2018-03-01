package fr.treeptik;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.io.IOException;
import java.lang.Integer;
import java.lang.String;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class CompteurMotsTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private CompteurMot compteurMot;
    private Map<String, Long> comptés;
    private Map<String, Long> attendus;

    @Before
    public void setup() {
        compteurMot = new fr.treeptik.CompteurMot();
        attendus = new HashMap<>();
    }

    @Test
    public void countEmptyTexte() {
        comptés = compteurMot.phrase("");
        assertEquals(0, comptés.entrySet().size());
    }

    @Test
    public void countNullableTexte() {

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Input cannot be null");

        comptés = compteurMot.phrase(null);
        assertEquals(0, comptés.entrySet().size());
    }

    @Test
    public void countOneWord() {
        attendus.put("foo", 1L);

        comptés = compteurMot.phrase("foo");
        assertEquals(
                attendus, comptés
        );
    }

    @Test
    public void testMiniscule() {
        // given
        String foo = "FoO";

        // when
        String toLowerFoo = compteurMot.minuscule(foo);

        // then
        assertEquals(
                "foo", toLowerFoo
        );
    }

    @Test
    public void testRegrouperMots() {
        // given
        List<String> mots = Stream.of("foo", "bar", "foo", "buzz").collect(Collectors.toList());
        // L'ordre d'insertion dans la map ne compte pas lors de l'assertion
        // car c'est une hashmap et pas une treemap
        Map<String, Long> solution = new HashMap<>();
        solution.put("buzz", 1L);
        solution.put("bar", 1L);
        solution.put("foo", 2L);

        // when
        Map<String, Long> occurences = compteurMot.regrouper(mots);

        // then
        assertEquals(solution, occurences);
    }

    @Test
    public void testTrierMots() {
        // given
        Map<String, Long> mots = new HashMap<>();
        mots.put("buzz", 1L);
        mots.put("bar", 1L);
        mots.put("foo", 2L);

        Map<String, Long> solution = new LinkedHashMap<>();
        solution.put("foo", 2L);
        solution.put("buzz", 1L);
        solution.put("bar", 1L);

        // when
        Map<String, Long> occurences = compteurMot.trier(mots);
        System.out.println(solution);
        System.out.println(occurences);

        // then
        // On ne tient pas compte de l'ordre...
        assertEquals(solution, occurences);
    }

    @Test
    public void testRFC() {

        try {
            Path path = Paths.get("/Users/nicolas/software/formations-testing/WordCount/rfc0822.txt");
            byte[] fileBytes = Files.readAllBytes(path);
            String data = new String(fileBytes);

            CompteurMot compteurMot = new CompteurMot();
            System.out.println(compteurMot.phrase(data));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
