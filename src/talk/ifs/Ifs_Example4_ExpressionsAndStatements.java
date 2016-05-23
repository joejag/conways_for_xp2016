package talk.ifs;

public class Ifs_Example4_ExpressionsAndStatements {

    public boolean horrible(boolean foo, boolean bar, boolean baz) {
        if (foo) {
            if (bar) {
                return true;
            }
        }

        if (baz) {
            return true;
        } else {
            return false;
        }
    }

}
