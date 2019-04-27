import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeral {

    private static final Map<Integer, String> numerals = new LinkedHashMap<Integer, String>() {{
        put(1000, "M");
        put(900, "CM");
        put(500, "D");
        put(400, "CD");
        put(100, "C");
        put(90, "XC");
        put(50, "L");
        put(40, "XL");
        put(10, "X");
        put(9, "IX");
        put(5, "V");
        put(4, "IV");
        put(1, "I");
    }};

    private int arabicNumber;

    RomanNumeral(int arabicNumber) {
        this.arabicNumber = arabicNumber;
    }

    String getRomanNumeral() {

        StringBuilder result = new StringBuilder();

        numerals.forEach((arabic, roman) -> {
            while (arabicNumber >= arabic) {
                arabicNumber -= arabic;
                result.append(roman);
            }
        });

        return result.toString();

    }

}
