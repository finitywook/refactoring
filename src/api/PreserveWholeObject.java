package api;

/**
 * Preserve Whole Object
 *
 * 객체 통째로 넘기기
 */
public class PreserveWholeObject {

    static class Old {
        private static final int TEMP_RANGE_LOW = -10;
        private static final int TEMP_RANGE_HIGH = 27;

        public boolean withinRange(int bottom, int top) {
            return bottom >= TEMP_RANGE_LOW
                    && top <= TEMP_RANGE_HIGH;
        }
    }

    static class New {
        private static final int TEMP_RANGE_LOW = -10;
        private static final int TEMP_RANGE_HIGH = 27;

        public boolean withinRange(TempRange tempRange) {
            return tempRange.low >= TEMP_RANGE_LOW
                    && tempRange.high <= TEMP_RANGE_HIGH;
        }
    }

    static class Room {
        TempRange tempRange;
    }

    static class TempRange {
        int low;
        int high;

        // withinRange 메서드를 여기에 만들면 더 깔끔!
    }
}
