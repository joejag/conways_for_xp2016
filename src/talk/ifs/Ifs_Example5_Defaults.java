package talk.ifs;

public class Ifs_Example5_Defaults {

    private class Repository {
        public String getRecord(int id) {
            return null; // cannot find the thing
        }
    }


    private class Finder {
        public String displayRecord(Repository repository) {
            String record = repository.getRecord(123);
            if(record == null) {
                return "Not found";
            } else {
                return record;
            }
        }
    }
}
