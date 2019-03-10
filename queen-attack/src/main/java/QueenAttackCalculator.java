public class QueenAttackCalculator {

    private Queen queen1;
    private Queen queen2;

    QueenAttackCalculator(Queen queen1, Queen queen2) {
        if(queen1 == null || queen2 == null) {
            throw new IllegalArgumentException("You must supply valid positions for both Queens.");
        } else if(queen1.equals(queen2)) {
            throw new IllegalArgumentException("Queens cannot occupy the same position.");
        } else {
            this.queen1 = queen1;
            this.queen2 = queen2;
        }
    }

    private boolean areQueensInSameRow() {
        return queen1.getRow() == queen2.getRow();
    }

    private boolean areQueensInSameColumn() {
        return queen1.getColumn() == queen2.getColumn();
    }

    private boolean areQueensInSameDiagonal() {
       int rowDiff = Math.abs(queen1.getRow() - queen2.getRow());
       int colDiff = Math.abs(queen1.getColumn() - queen2.getColumn());

       return rowDiff == colDiff;
    }

    boolean canQueensAttackOneAnother() {
        return areQueensInSameRow() || areQueensInSameColumn() || areQueensInSameDiagonal();
    }

}
