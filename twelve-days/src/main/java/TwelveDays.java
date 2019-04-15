import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class TwelveDays {

    private static String base = "On the %s day of Christmas my true love gave to me: ";
    private static Map<Integer, String> dayVerse = new HashMap<Integer, String>(){{
        put(1, "a Partridge in a Pear Tree.\n");
        put(2, "two Turtle Doves");
        put(3, "three French Hens");
        put(4, "four Calling Birds");
        put(5, "five Gold Rings");
        put(6, "six Geese-a-Laying");
        put(7, "seven Swans-a-Swimming");
        put(8, "eight Maids-a-Milking");
        put(9, "nine Ladies Dancing");
        put(10, "ten Lords-a-Leaping");
        put(11, "eleven Pipers Piping");
        put(12, "twelve Drummers Drumming");
    }};
    private static Map<Integer, String> ordinals = new HashMap<Integer, String>(){{
       put(1, "first");
       put(2, "second");
       put(3, "third");
       put(4, "fourth");
       put(5, "fifth");
       put(6, "sixth");
       put(7, "seventh");
       put(8, "eighth");
       put(9, "ninth");
       put(10, "tenth");
       put(11, "eleventh");
       put(12, "twelfth");
    }};

    String verse(int verseNumber) {
        if (verseNumber == 1) return singleFirstVerse();

        String init = String.format(base, ordinals.get(verseNumber));
        AtomicInteger verse = new AtomicInteger(verseNumber);

        String collect = IntStream.generate(verse::getAndDecrement)
                .limit(verseNumber)
                .mapToObj(value -> {
                    if (value == 1)
                        return "and ".concat(dayVerse.get(value));
                    else
                        return dayVerse.get(value).concat(", ");
                }).collect(Collectors.joining(""));

        return init.concat(collect);
    }

    String verses(int startVerse, int endVerse) {
        return IntStream.rangeClosed(startVerse, endVerse)
                .mapToObj(this::verse)
                .collect(Collectors.joining("\n"));
    }
    
    String sing() {
        return verses(1, 12);
    }

    private String singleFirstVerse() {
        return String.format(base, "first").concat(dayVerse.get(1));
    }
}
