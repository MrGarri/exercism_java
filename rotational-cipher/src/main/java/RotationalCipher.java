class RotationalCipher {

    private int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        StringBuilder encryption = new StringBuilder();

        data.codePoints().forEach(c -> {
            if(Character.isUpperCase(c)) {
                encryption.append((char)(((c - 65 + shiftKey) % 26) + 65));
            } else if(Character.isLowerCase(c)) {
                encryption.append((char)(((c - 97 + shiftKey) % 26) + 97));
            } else {
                encryption.append(Character.toChars(c));
            }
        });

        return encryption.toString();
    }

}
