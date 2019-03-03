import java.util.HashSet;
import java.util.Set;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        String s = phrase.toLowerCase().replaceAll("[^a-z0-9]", "");

        Set<Character> characterSet = new HashSet<>();

        s.chars().forEach(c -> {
            characterSet.add((char) c);
        });

        return characterSet.size() == s.length();
    }

}
