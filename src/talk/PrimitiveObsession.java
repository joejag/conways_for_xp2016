package talk;

public class PrimitiveObsession {

    private class User {
        private String name;
        private String email;
        
        private String tshirtPreference;

        public String getTshirtPreference() {
            return tshirtPreference;
        }
    }

    public void decideTshirtToPutInBag(User user){
        if(user.getTshirtPreference().toLowerCase().equals("red")) {
            // do something
        }
    }
}
