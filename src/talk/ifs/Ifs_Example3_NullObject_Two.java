package talk.ifs;

public class Ifs_Example3_NullObject_Two {

    private static class User {

        private String name;
        private int points;

        public User(String name, int points) {
            this.name = name;
            this.points = points;
        }

        public String getName() {
            return name;
        }
        public int getPoints() {
            return points;
        }
    }

    private class DisplayUser {

        public String showUserInfo(User user) {
            if(user == null) {
                return "Anon Coward: 0";
            }

            return user.getName() + ": " + user.getPoints();
        }

    }

}
