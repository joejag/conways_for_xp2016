package talk.lod;

import java.util.ArrayList;
import java.util.List;

public class LawOfDemeter_Example1 {

    private class Pizza {
        private int price;
        private List<Topping> toppings = new ArrayList<>();

        public int getPrice() {
            return price;
        }


        public List<Topping> getToppings() {
            return toppings;
        }
    }

    private class Topping {
        private String name;

        public Topping(String name) {
            this.name = name;
        }

        public int getWeight() {
            return 1;
        }
    }

    private class PizzaBuilder {
        private Topping topping;

        public void theGood(Pizza pizza) {
            // 1. It's cool to call our own methods
            cleanPreparationArea();

            // 2. It's cool to call methods on objects passed into our methods
            int price = pizza.getPrice();

            // 3. It's cool to call methods on objects we create
            topping = new Topping("mushrooms");
            int weight = topping.getWeight();

            // 4. It's cool to call methods on locally create objects
            List<String> steps = new ArrayList<>();
            steps.add("Turn oven on");
        }

        public void theBad(Pizza pizza) {
            // 5. It's not cool to call methods belonging to objects that were returned from some other call
            List<Topping> toppings = pizza.getToppings();
            toppings.clear();
            toppings.add(new Topping("egg"));
        }

        private void cleanPreparationArea() {

        }

    }
}
