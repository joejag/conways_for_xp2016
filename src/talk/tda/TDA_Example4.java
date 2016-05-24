package talk.tda;

import java.util.Iterator;
import java.util.List;

public class TDA_Example4 {

    public void exampleOne(List<String> strings) {

        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
    }

}
