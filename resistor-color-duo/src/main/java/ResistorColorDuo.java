import java.util.Arrays;
import java.util.stream.Collectors;

class ResistorColorDuo {

    private enum values {
        black("0"),
        brown("1"),
        red("2"),
        orange("3"),
        yellow("4"),
        green("5"),
        blue("6"),
        violet("7"),
        grey("8"),
        white("9");

        private String value;

        private values(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    int value(String[] colors) {
        String resistorValue = Arrays.stream(colors).limit(2)
                .map(color -> values.valueOf(color).getValue())
                .collect(Collectors.joining());
        return Integer.parseInt(resistorValue);
    }
}
