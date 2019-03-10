class CollatzCalculator {

    private int steps = 0;

    int computeStepCount(int start) {
        if(start < 1)
            throw new IllegalArgumentException("Only natural numbers are allowed");

        if(start % 2 == 0) {
            steps++;
            return computeStepCount(start / 2);
        } else if (start > 1) {
            steps++;
            return computeStepCount(start * 3 + 1);
        }

        return steps;
    }
}
