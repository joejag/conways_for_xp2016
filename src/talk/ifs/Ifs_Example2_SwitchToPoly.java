package talk.ifs;

public class Ifs_Example2_SwitchToPoly {

    private static class Bird {

        private enum Species {
            EUROPEAN, AFRICAN, NORWEGIAN_BLUE;
        }

        private boolean isNailed;
        private Species type;

        public double getSpeed() {
            switch (type) {
                case EUROPEAN:
                    return getBaseSpeed();
                case AFRICAN:
                    return getBaseSpeed() - getLoadFactor();
                case NORWEGIAN_BLUE:
                    return isNailed ? 0 : getBaseSpeed();
                default:
                    return 0;
            }
        }

        private double getLoadFactor() {
            return 3;
        }

        private double getBaseSpeed() {
            return 10;
        }
    }


}
