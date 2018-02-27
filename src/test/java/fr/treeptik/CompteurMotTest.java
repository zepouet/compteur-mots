package fr.treeptik;

import org.junit.Before;
import org.junit.Test;

import java.lang.Integer;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CompteurMotTest {

    private CompteurMot compteurMot;
    private Map<Integer, String> comptés;
    private Map<Integer, String> attendus;

    @Before
    public void setup() {
        compteurMot = new fr.treeptik.CompteurMot();
        attendus = new HashMap<>();
    }


    @Test
    public void countOneWord() {
        attendus.put(1, "foo");

        comptés = compteurMot.phrase("foo");
        assertEquals(
                attendus, comptés
        );
    }
}
