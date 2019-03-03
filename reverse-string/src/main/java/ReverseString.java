class ReverseString {

    String reverse(String inputString) {

        StringBuilder sb = new StringBuilder();

        inputString.chars().forEach(c -> sb.insert(0, (char) c));

        return sb.toString();

    }
  
}