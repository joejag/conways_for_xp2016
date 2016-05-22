package talk.connascence;

public class Connascence_1_OfName {

    // Connascence of name - agreeing on the name of something
    // Most common type

    // Example 1
    public void naming() {
        int age;
        age = 35;
    }



    // Example 2
    enum VehicleType {
        CAR, BOAT, BUS;
    }

    private class Vehicle {

        private VehicleType type;

        public Vehicle(VehicleType type) {
            this.type = type;
        }
    }

    public Vehicle makeVehicle() {
        return new Vehicle(VehicleType.BOAT);
    }



    // Example 3
    @Override
    public String toString() {
        return "Bob";
    }

    @Override
    public int hashCode() {
        return 11;
    }
}
