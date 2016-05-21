package talk;

public class ExampleCode {
//
//    // Invariants
//    public void makeStringsLowercase() {
//        ArrayList<String> strings = new ArrayList<>();
//
//        ArrayList<String> procedural = procedural(strings);
//        List<String> declarative = declarative(strings);
//    }
//
//    private ArrayList<String> procedural(ArrayList<String> strings) {
//        Iterator<String> iterator = strings.iterator();
//        ArrayList<String> result = new ArrayList<>();
//        while(iterator.hasNext()) {
//            String next = iterator.next();
//            result.add(next.toLowerCase());
//        }
//
//        return result;
//    }

//    private List<String> declarative(ArrayList<String> strings) {
//        return strings.stream().map(String::toLowerCase)
//                .collect(Collectors.toList());
//    }
//
//    // Law of Demeter
//
//    public void getName() {
//        Person.profiles().first().getFirstName();
//        Person.getFirstName();
//    }
//
//    public void addFizz() {
//        List<String> a = ShoppingCart.getItems();
//        a.add(a.first.asd, "");
//
//        ShoppingCart.addItem("");
//    }
//
//    // anti -if
//
//    public void saveFile() {
//        // shared state
//
//        if(true) {
//            // use shared state
//        } else {
//            // use shared state
//        }
//
//        File.saveFile("name.txt", "contents", true);
//
//        File.saveFile("name.txt", "contents");
//        File.saveTempFile("name.txt", "contents");
//
//        // fetch('', nil);
//
//        // predicate example
//
//        // polymorphism example
//        if(a == CAR) {
//            a.park()
//        } else (a == VAN) {
//            a.reverse()
//        }
//    }



}
