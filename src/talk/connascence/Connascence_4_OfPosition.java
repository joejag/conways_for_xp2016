package talk.connascence;

import java.awt.*;

public class Connascence_4_OfPosition {

    // Must be adjacent or occur in a particular order

    // Example 1
    public void readArray() {
        String[] vehicles = new String[]{"ford", "fiesta", "hatchback"};

        String make = vehicles[0];
        String model = vehicles[1];
        String bodyStyle = vehicles[2];
    }



    // Example 2
    public void createPoint() {
        new Point(2, 3);
    }



    // Example 3
    public void createEmail() {
        new Email("joe@hotmail.com", "jane@hotmail.com", "A a great day", "you've won a free trip").send();
    }

    private class Email {
        public Email(String from, String to, String subject, String body) {
        }

        public void send() {

        }
    }
}
