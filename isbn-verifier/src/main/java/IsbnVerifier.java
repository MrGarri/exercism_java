class IsbnVerifier {

    boolean isValid(String stringToVerify) {

        boolean result;

        String s = stringToVerify.replaceAll("[^0-9X]", "");

        if(s.length() != 10) {
            result = false;
        } else {
            int multiplier = 10;
            int acc = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == 'X')
                    acc += 10;
                else
                    acc += s.charAt(i) * multiplier;
                multiplier--;
            }

            result = acc % 11 == 0;
        }

        return result;

    }

}
