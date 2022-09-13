package api;

/**
 * Replace Query With Parameter
 *
 * 질의 함수를 매개변수로 바꾸기
 */
public class ReplaceQueryWithParameter {

    static class Old {
        private static int SELECTED_TEMPERATURE = 26;
        private static final int MAX = 30;
        private static final int MIN = 25;

        public static void main(String[] args) {
            Old old = new Old();

            old.targetTemperature();
        }

        public int targetTemperature() {
            if(SELECTED_TEMPERATURE > MAX) {
                return MAX;
            } else if(SELECTED_TEMPERATURE < MIN) {
                return MIN;
            }

            return SELECTED_TEMPERATURE;
        }
    }

    static class New {
        private static int SELECTED_TEMPERATURE = 26;
        private static final int MAX = 30;
        private static final int MIN = 25;

        public static void main(String[] args) {
            New aNew = new New();

            aNew.targetTemperature(SELECTED_TEMPERATURE);
        }

        public int targetTemperature(int selectedTemperature) {
            if(selectedTemperature > MAX) {
                return MAX;
            } else if(selectedTemperature < MIN) {
                return MIN;
            }

            return selectedTemperature;
        }
    }
}
