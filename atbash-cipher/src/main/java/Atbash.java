public class Atbash {

    public String encode(String input) {

        String encoding = input.codePoints()
                .filter(Character::isLetterOrDigit)
                .map(Character::toLowerCase)
                .map(character -> {
                    if (Character.isLetter(character))
                        return 'a' + (26 - (character - ('a' - 1)));
                    else
                        return character;
                })
                .collect(
                        StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append
                ).toString();

        return chunker(encoding);

    }

    public String decode(String input) {
        return encode(input).replaceAll("\\W", "");
    }

    private String chunker(String input) {
        return input.replaceAll(".{5}(?=.)", "$0 ");
    }

}
