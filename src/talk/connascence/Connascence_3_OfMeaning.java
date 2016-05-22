package talk.connascence;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class Connascence_3_OfMeaning {

    // when multiple components must agree on the meaning of specific values. (magic values)

    // Example 1
    public int isTheAfternoon() {
        if (LocalDateTime.now().getHour() > 12) {
            return 1;
        } else {
            return 0;
        }
    }

    public String whichMenuToUse() {
        if (isTheAfternoon() == 1) {
            return "Pre-Theatre menu";
        } else {
            return "Breakfast menu";
        }
    }



    // Example 2
    private LocalDate myDateOfBirth = null;
    public LocalDate getDateOfBirth() {
        if(myDateOfBirth == null) return LocalDate.of(9999, Month.JANUARY, 1);
        return myDateOfBirth;
    }

    public String shouldISayHappyBirthday() {
        LocalDate dateOfBirth = getDateOfBirth();
        if(dateOfBirth.equals(LocalDate.of(9999, Month.JANUARY, 1))) {
            return "no";
        }

        return "maybe"; // TODO: Implement :)
    }
}
