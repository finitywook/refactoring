package api;

/**
 * Replace Exception With Pre Check
 *
 * 예외를 사전확인으로 바꾸기
 */
public class ReplaceExceptionWithPreCheck {

    static class Old {
        private double[] values;

        public double getValueForPeriod(int periodNumber) {
            try {
                return values[periodNumber];
            } catch (ArrayIndexOutOfBoundsException e) {
                return 0;
            }
        }
    }

    static class New {
        private double[] values;

        public double getValueForPeriod(int periodNumber) {
            return periodNumber >= values.length ? 0 : values[periodNumber];
        }
    }
}
