package talk.connascence;

import java.awt.*;

public class Connascence_4_OfPosition {

    // Must be adjacent or occur in a particular order

    // Example 1
    public void readArray() {
        String[] vehicles = new String[]{"ford", "fiesta", "hatchback"};

        String make = vehicles[0];
        String model = vehicles[0];
        String bodyStyle = vehicles[0];
    }



    // Example 2
    public void createPoint() {
        new Point(2, 3);

        new Email("joe@hotmail.com", "jane@hotmail.com", "A subject line", "a message body");
    }

    private class Email {
        public Email(String from, String to, String subject, String body) {
        }
    }
}
