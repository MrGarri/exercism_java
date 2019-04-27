import java.util.function.BiFunction;

public class WordProblemSolver {

    int solve(String input) {

        String[] split = input.split("[\\s\\?]");

        Integer result = null;
        Integer operand = null;
        BiFunction<Integer, Integer, Integer> operator = null;

        for (String s : split) {
            if (isNumeric(s)) {
                if (result == null) {
                    if (operand == null)
                        operand = Integer.valueOf(s);
                    else
                        result = operator.apply(operand, Integer.valueOf(s));
                } else {
                    result = operator.apply(result, Integer.valueOf(s));
                }
            } else {
                switch (s) {
                    case "plus":
                        operator = WordProblemSolver::add;
                        break;
                    case "minus":
                        operator = WordProblemSolver::subtract;
                        break;
                    case "multiplied":
                        operator = WordProblemSolver::multiply;
                        break;
                    case "divided":
                        operator = WordProblemSolver::divide;
                }
            }
        }

        if (result == null)
            throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
        return result;
    }

    static boolean isNumeric(String num) {
        return num.matches("-?\\d+");
    }

    private static int add(Integer a, Integer b) {
        return a + b;
    }

    private static Integer subtract(Integer a, Integer b) {
        return a - b;
    }

    private static Integer multiply(Integer a, Integer b) {
        return a * b;
    }

    private static Integer divide(Integer a, Integer b) {
        return a / b;
    }

}
