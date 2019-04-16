import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Series {

    private String strand;

    public Series(String strand) {
        this.strand = strand;
    }

    public List<String> slices(int window) {
        if (window > strand.length()) throw new IllegalArgumentException("Slice size is too big.");
        if (window < 1) throw new IllegalArgumentException("Slice size is too small.");

        return IntStream.rangeClosed(0, strand.length() - window)
                .mapToObj(i -> strand.substring(i, i + window))
                .collect(Collectors.toList());
    }
}
