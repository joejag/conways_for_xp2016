package talk.tda;

public class TDA_Example2 {

    private class SystemMonitor {

        public int getTemperature() {
            return 99;
        }

        public void soundAlarms() {
            System.out.println("Woo woo woo!");
        }
    }


    private class DoThings {

        public void checkForOverheating(SystemMonitor monitor) {
            if (monitor.getTemperature() > 100) {
                monitor.soundAlarms();
            }
        }

    }
}
