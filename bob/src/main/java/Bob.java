public class Bob {

    private static final String QUESTION = "Sure.";
    private static final String YELLING = "Whoa, chill out!";
    private static final String YELLING_QUESTION = "Calm down, I know what I'm doing!";
    private static final String EMPTY_INPUT = "Fine. Be that way!";
    private static final String ANYTHING_ELSE = "Whatever.";

    public String hey(String input) {
        if (input.isEmpty() || input.matches("\\s+"))
            return EMPTY_INPUT;

        String sanitizedInput = input.replaceAll("[^a-zA-Z0-9?]", "");
        boolean question = isQuestion(sanitizedInput);
        boolean yelling = isYelling(sanitizedInput);

        if (question && yelling)
            return YELLING_QUESTION;
        else if (question)
            return QUESTION;
        else if (yelling)
            return YELLING;
        else
            return ANYTHING_ELSE;
    }

    private boolean isQuestion(String candidate) {
        return candidate.endsWith("?");
    }

    private boolean isYelling(String candidate) {
        return candidate.replaceAll("[^a-zA-Z]", "").matches("^[A-Z]+$");
    }

}
