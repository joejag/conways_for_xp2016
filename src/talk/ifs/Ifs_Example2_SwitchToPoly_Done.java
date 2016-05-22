package talk.ifs;

public class Ifs_Example2_SwitchToPoly_Done {

    private static abstract class Bird {

        public abstract double getSpeed();

        protected double getLoadFactor() {
            return 3;
        }

        protected double getBaseSpeed() {
            return 10;
        }
    }

    public class EuropeanBird extends Bird {
        public double getSpeed() {
            return getBaseSpeed();
        }
    }

    public class AfricanBird extends Bird {
        public double getSpeed() {
            return getBaseSpeed() - getLoadFactor();
        }
    }

    public class NorwegianBird extends Bird {
        private boolean isNailed;

        public double getSpeed() {
            return isNailed ? 0 : getBaseSpeed();
        }
    }
}
