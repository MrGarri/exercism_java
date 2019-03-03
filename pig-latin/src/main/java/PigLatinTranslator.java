import java.util.Arrays;
import java.util.stream.Collectors;

public class PigLatinTranslator {

    public String translate(String input) {

        String[] split = input.split(" ");
        String result = "";

        for(String s : split) {
            result += translateWord(s) + " ";
        }

        return result.trim();

    }

    public String translateWord(String input) {

        StringBuilder result = new StringBuilder(input);

        if(input.matches("^(qu).*")){
            return translate(result.delete(0,2).append("qu").toString());
        } else if(input.matches("^([aeiou]|[xy][^aeiou]).*")) {
            return result.append("ay").toString();
        }  else {
            char c = result.charAt(0);
            result = result.deleteCharAt(0).append(c);
        }

        return translate(result.toString());

    }

}
