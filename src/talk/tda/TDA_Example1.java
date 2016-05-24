package talk.tda;

public class TDA_Example1 {

    private class User {
        boolean admin;

        public User(boolean admin) {
            this.admin = admin;
        }

        public boolean isAdmin() {
            return admin;
        }

        public String getAdminWelcomeMessage() {
            return "Hello admin";
        }

        public String getUserWelcomeMessage() {
            return "Hello user";
        }
    }

    private class Displayer {

        public String getWelcomeMessage(User currentUser) {
            if (currentUser.isAdmin()) {
                return currentUser.getAdminWelcomeMessage();
            } else {
                return currentUser.getUserWelcomeMessage();
            }
        }

    }
}
