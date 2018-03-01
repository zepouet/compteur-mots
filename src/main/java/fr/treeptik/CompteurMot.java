package fr.treeptik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CompteurMot {

    /**
     * Méthode principale qui assemble les autres méthodes *pures* :-)
     * @param texte
     * @return
     *
     */
    public Map<String,Long> phrase(String texte) {
        if (texte == null) { throw new IllegalArgumentException("Input cannot be null"); }
        texte = minuscule(texte);
        List<String> words = decouper(texte);
        Map<String, Long> wordGrouped = regrouper(words);
        Map<String, Long> wordGroupedAndSorted = trier(wordGrouped);
        return wordGroupedAndSorted;
    }

    // Ok c'est trivial mais bon...
    public String minuscule(String foo) {
        return foo.toLowerCase();
    }

    // On découpe les mots et on ne conserve que ceux dont la taille est > 1
    public List<String> decouper(String chaine) {
        if(chaine.length()==0) { return new ArrayList<String>(); }
        List<String> mots =  Arrays.asList(chaine.split("\\W+"));
        return mots.stream()
                .map(mot -> mot.toLowerCase())
                .filter(mot -> mot.length()>1)
                .collect(Collectors.toList());
    }

    // On convertit une List<String> en Map<String, Long>
    // Exemple <"foo", "bar", "foo"> en "[<"foo", 2>, <"bar", 1>]
    // Merci l'API Stream
    public Map<String, Long> regrouper(List<String> mots) {
        return
                mots
                        .stream()
                        .collect(
                                Collectors.groupingBy(
                                    Function.identity(),
                                        Collectors.counting())
                        )
                ;
    }

    public Map<String, Long> trier(Map<String, Long> mots) {
        //HashMap makes absolutely no guarantees about the iteration order. It can (and will) even change completely when new elements are added.
        //TreeMap will iterate according to the "natural ordering" of the keys according to their compareTo() method (or an externally supplied Comparator). Additionally, it implements the SortedMap interface, which contains methods that depend on this sort order.
        //LinkedHashMap will iterate in the order in which the entries were put into the map
        Map<String, Long> resultat = new LinkedHashMap<>();
        mots.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(e -> resultat.put(e.getKey(), e.getValue()));
        return resultat;
    }


}
