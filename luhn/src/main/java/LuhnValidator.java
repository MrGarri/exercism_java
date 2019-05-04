class LuhnValidator {

    boolean isValid(String candidate) {
        StringBuilder sanitizedCandidate = new StringBuilder(candidate.replaceAll(" ", ""));
        if (sanitizedCandidate.length() < 2 ||
                sanitizedCandidate.chars().anyMatch(character -> !Character.isDigit(character))) {
            return false;
        }

        sanitizedCandidate.reverse();

        for (int i = 1; i < sanitizedCandidate.length(); i += 2) {

            int numericValue = Character.getNumericValue(sanitizedCandidate.charAt(i));
            numericValue *= 2;
            if (numericValue > 9)
                numericValue -= 9;

            sanitizedCandidate.setCharAt(i, Character.forDigit(numericValue, 10));

        }

        int sum = sanitizedCandidate.chars()
                .map(Character::getNumericValue)
                .sum();

        return sum % 10 == 0;

    }

}
