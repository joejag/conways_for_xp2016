package talk.ifs;

public class Ifs_Example1_BooleanParam {

    public void example() {
        FileUtils.createFile("name.txt", "file contents", false);
        FileUtils.createFile("name_test.txt", "file contents", true);
    }

    private static class FileUtils {
        public static void createFile(String name, String contents, boolean temporary) {
            // file magic
        }
    }
}
