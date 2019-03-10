class NaturalNumber {

    private final int number;

    NaturalNumber(int number) {
        if(number < 1) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        } else {
            this.number = number;
        }
    }

    private int aliquotSum() {
        int sum = 0;

        for(int i = 1; i <= number/2; i++) {
            if(number % i == 0)
                sum += i;
        }

        return sum;
    }

    Classification getClassification() {
        Classification classification;

        if(aliquotSum() == number)
            classification = Classification.PERFECT;
        else if(aliquotSum() < number)
            classification = Classification.DEFICIENT;
        else
            classification = Classification.ABUNDANT;

        return classification;
    }

}
