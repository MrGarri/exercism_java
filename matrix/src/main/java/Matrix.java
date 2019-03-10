import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Matrix {

    private String matrix;

    Matrix(String matrixAsString) {
        this.matrix = matrixAsString;
    }

    private List<int[]> rows() {
        List<int[]> rows = new ArrayList<>();

        String[] s = matrix.split("\n");

        for (int i = 0; i < s.length; i++) {
            rows.add(i, (Arrays.stream(s[i].split(" ")).mapToInt(Integer::parseInt).toArray()));
        }

        return rows;
    }

    int[] getRow(int rowNumber) {
        return rows().get(rowNumber);
    }

    int[] getColumn(int columnNumber) {
        List<Integer> column = new ArrayList<>();

        rows().forEach(row -> column.add(row[columnNumber]));

        return column.stream().mapToInt(Integer::intValue).toArray();
    }
}
