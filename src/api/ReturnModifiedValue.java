package api;

/**
 * Return Modified Value
 *
 * 수정된 값 반환하기
 */
public class ReturnModifiedValue {

    static class Old {
        int totalAscent = 0;
        int totalTime = 0;
        int totalDistance = 0;

        public int gps() {
            calculateAscent();
            calculateTime();
            calculateDistance();

            return totalTime / 60 / totalDistance;
        }

        public void calculateAscent() {
            // action
            this.totalAscent = 100;
        }

        public void calculateTime() {
            // action
            this.totalTime = 60;
        }

        public void calculateDistance() {
            // action
            this.totalDistance = 1000;
        }
    }

    static class New {
        public int gps() {
            int totalAscent = calculateAscent();
            int totalTime = calculateTime();
            int totalDistance = calculateDistance();

            return totalTime / 60 / totalDistance;
        }

        public int calculateAscent() {
            // action
            return 100;
        }

        public int calculateTime() {
            // action
            return 60;
        }

        public int calculateDistance() {
            // action
            return 1000;
        }
    }
}
