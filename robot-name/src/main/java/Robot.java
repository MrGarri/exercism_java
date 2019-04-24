import java.util.Iterator;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Robot {

    private Iterator<String> names = Stream.generate(Robot::generateRandomName).distinct().iterator();

    private String name = names.next();

    public String getName() {
        return name;
    }

    public void reset() {
        this.name = names.next();
    }

    private static String generateRandomName() {

        Random random = new Random();
        StringBuilder result = new StringBuilder();

        // Generate two random letters
        for (int i = 0; i < 2; i++)
            result.append(Character.toChars(random.nextInt(10) + 65));

        // Generate three random numbers
        for (int i = 0; i < 3; i++)
            result.append(random.nextInt(10));

        return result.toString();

    }

}
