package talk.lod;

import java.util.List;

public class LawOfDemeter_Example2 {

    private class User {

        List<Profile> profiles;

        public List<Profile> getProfiles() {
            return profiles;
        }
    }

    private class Profile {

        private Name name;

        public Name getName() {
            return name;
        }
    }

    private class Name {
        private String firstName;

        public String getFirstName() {
            return firstName;
        }
    }

    private class UserDisplay {

        public String showName(User user) {
            return user.getProfiles().iterator().next().getName().getFirstName();
        }
    }
}
