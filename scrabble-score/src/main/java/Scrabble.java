import java.util.concurrent.atomic.AtomicInteger;

class Scrabble {

    private String word;

    Scrabble(String word) {
        this.word = word;
    }

    int getScore() {
        AtomicInteger score = new AtomicInteger(0);

        word.codePoints().forEach(c -> score.addAndGet(
                Scores.valueOf(new StringBuilder().appendCodePoint(c).toString().toUpperCase()).getScore()
        ));

        return score.get();
    }

}
