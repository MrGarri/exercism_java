import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Allergies {

    private int score;
    private List<Allergen> allergenList;

    public Allergies (int score) {
        this.score = score;
        this.allergenList = score > 255 ? Arrays.asList(Allergen.EGGS) : generateAllergenList();
    }

    public boolean isAllergicTo(Allergen allergen) {

        return this.allergenList.contains(allergen);

    }

    private List<Allergen> generateAllergenList() {

        List<Allergen> allergenList = new ArrayList<>();

        ListIterator<Allergen> it = Arrays.asList(Allergen.values())
                .listIterator(Arrays.asList(Allergen.values()).size());

        while(it.hasPrevious()) {
            Allergen allergen = it.previous();
            int allergenScore = allergen.getScore();
            if(allergenScore <= this.score) {
                allergenList.add(0, allergen);
                this.score -= allergenScore;
            }
        }

        return allergenList;

    }

    List<Allergen> getList() {
        return this.allergenList;
    }

}
