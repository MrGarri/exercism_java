import java.util.stream.IntStream;

class ArmstrongNumbers {

	boolean isArmstrongNumber(int numberToCheck) {

		String numToString = String.valueOf(numberToCheck);
		int numLength = numToString.length();

		double sumOfPowers = IntStream.range(0, numLength)
				.mapToObj(numToString::charAt)
				.mapToInt(Character::getNumericValue)
				.mapToDouble(digit -> Math.pow(digit, numLength))
				.sum();

		return (int) sumOfPowers == numberToCheck;

	}

}
