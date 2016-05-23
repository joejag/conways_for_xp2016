package talk.connascence;

import java.util.ArrayList;
import java.util.List;

public class Connascence_2_OfType {

    // Connascence of Type - agreeing on the type of something

    // Example 1
    public void naming() {
        int age = 34;
        age = 35;
    }



    // Example 2
    public List<String> makeSomething() {
        return new ArrayList<>();
    }



    // Example 3
    @Override
    public String toString() {
        return "Bob";
    }

    @Override
    public int hashCode() {
        return 11;
    }
}
