import sun.awt.SunHints;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearch {

    private List<Integer> values;

    public BinarySearch(List<Integer> values) {
        this.values = values;
    }

    public int indexOf(int element) throws ValueNotFoundException {

        int bottom = 0;
        int top = values.size() - 1;
        int result = -1;

        while (bottom <= top) {
            int middle = (bottom + top) / 2;

            if (values.get(middle) < element)
                bottom++;
            else if (values.get(middle) > element)
                top--;
            else {
                result = middle;
                break;
            }
        }

        if (result < 0)
            throw new ValueNotFoundException("Value not in array");

        return result;

    }

}
