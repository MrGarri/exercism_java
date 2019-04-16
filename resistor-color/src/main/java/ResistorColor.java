import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class ResistorColor {

    private static final Map<String, Integer> colours = new LinkedHashMap<String, Integer>() {{
        put("black", 0);
        put("brown", 1);
        put("red", 2);
        put("orange", 3);
        put("yellow", 4);
        put("green", 5);
        put("blue", 6);
        put("violet", 7);
        put("grey", 8);
        put("white", 9);
    }};

    int colorCode(String color) {
        return colours.get(color);
    }

    String[] colors() {
        String[] coloursArray = new String[colours.size()];
        return colours.keySet().toArray(coloursArray);
    }
}
