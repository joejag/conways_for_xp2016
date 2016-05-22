package talk.connascence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Connascence_5_OfExecution {

    // two different lines of code have to be executed in a certain order for the program to be executed correctly.

    // Example 1
    public void exampleOne() {
        List<String> strings = new ArrayList<>();
        Iterator<String> iterator = strings.iterator();

        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
    }


    // Example 2
    public void exampleTwo() {
        Car car = new Car();
        car.setTransmission("manual");
        car.driveAway();
    }

    private class Car {
        private String transmission;

        public void setTransmission(String transmission) {
            this.transmission = transmission;
        }

        public void driveAway() {
            if (transmission.equals("manual")) {
                System.out.println("put car into first gear");
            } else if (transmission.equals("automatic")) {
                System.out.println("put car into 'drive'");
            } else {
                System.out.println("get out the car and push");
            }
        }
    }
}
