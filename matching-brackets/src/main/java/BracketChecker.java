import java.util.Iterator;
import java.util.Objects;
import java.util.Stack;
import java.util.stream.IntStream;

public class BracketChecker {

    private final String bracketsStrand;

    private final static String OPENING_BRACKETS = "([{";
    private final static String CLOSING_BRACKETS = ")]}";

    public BracketChecker(String bracketsStrand) {
        this.bracketsStrand = bracketsStrand;
    }

    boolean areBracketsMatchedAndNestedCorrectly() {

        Stack<String> stack = new Stack<>();

        Iterator<String> iterator = IntStream.range(0, bracketsStrand.length())
                .mapToObj(bracketsStrand::charAt)
                .map(String::valueOf)
                .iterator();

        while (iterator.hasNext()) {
            String character = iterator.next();

            if (OPENING_BRACKETS.contains(character)) {
                stack.push(character);
            } else if (CLOSING_BRACKETS.contains(character)) {
                if (stack.empty() || !Objects.equals(getClosingBracket(stack.peek()), character))
                    return false;
                stack.pop();
            }
        }

        return stack.empty();

    }

    private String getClosingBracket(String bracket) {
        switch (bracket) {
            case "(": return ")";
            case "[": return "]";
            case "{": return "}";
            default: return null;
        }
    }

}
