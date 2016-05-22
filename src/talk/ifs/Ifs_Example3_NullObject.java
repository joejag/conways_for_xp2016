package talk.ifs;

import java.util.ArrayList;
import java.util.List;

public class Ifs_Example3_NullObject {

    public void example() {
        sumOf(null);
    }

    private int sumOf(List<Integer> numbers) {
        if(numbers == null) {
            return 0;
        }

        return numbers.stream().mapToInt(i -> i).sum();
    }

}
