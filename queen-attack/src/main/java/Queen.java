public class Queen {

    private int row;
    private int column;

    Queen(int row, int column) {
        if(row >= 0) {
            if(row < 8) {
                this.row = row;
            } else {
                throw new IllegalArgumentException("Queen position must have row <= 7.");
            }
        } else {
            throw new IllegalArgumentException("Queen position must have positive row.");
        }

        if(column >= 0) {
            if(column < 8) {
                this.column = column;
            } else {
                throw new IllegalArgumentException("Queen position must have column <= 7.");
            }
        } else {
            throw new IllegalArgumentException("Queen position must have positive column.");
        }
    }

    @Override
    public boolean equals(Object queen) {
        Queen q = (Queen) queen;
        return this.row == q.getRow() && this.column == q.getColumn();
    }


    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
