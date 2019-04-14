import java.util.*;

class ProteinTranslator {

    private final Map<String, String> translations = new HashMap<String, String>() {{
        put("AUG", "Methionine");
        put("UUU", "Phenylalanine");
        put("UUC", "Phenylalanine");
        put("UUA", "Leucine");
        put("UUG", "Leucine");
        put("UCU", "Serine");
        put("UCC", "Serine");
        put("UCA", "Serine");
        put("UCG", "Serine");
        put("UAU", "Tyrosine");
        put("UAC", "Tyrosine");
        put("UGU", "Cysteine");
        put("UGC", "Cysteine");
        put("UGG", "Tryptophan");
        put("UAA", "STOP");
        put("UAG", "STOP");
        put("UGA", "STOP");
    }};

    List<String> translate(String rnaSequence) {

        List<String> chunks = chunker(rnaSequence, 3);
        List<String> result = new ArrayList<>();

        for (String chunk : chunks) {
            if (!translations.get(chunk).equals("STOP"))
                result.add(translations.get(chunk));
            else break;
        }

        return result;

    }

    private List<String> chunker(String str, int chunkSize) {
        List<String> chunks = new ArrayList<>();
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() > 0) {
            chunks.add(sb.substring(0, Integer.min(chunkSize, sb.length())));
            sb.delete(0, Integer.min(chunkSize, sb.length()));
        }
        return chunks;
    }
}