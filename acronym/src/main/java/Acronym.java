import java.util.stream.Stream;

class Acronym {

    private final String phrase;

    Acronym(String phrase) {
        this.phrase = phrase;
    }

    String get() {

        StringBuilder result = new StringBuilder();

        Stream.of(phrase.split("[^a-zA-Z']"))
                .filter(word -> !word.isEmpty())
                .map(word -> word.charAt(0))
                .forEach(result::append);

        return result.toString().toUpperCase();

    }

}
