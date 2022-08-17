package basic;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Introduce Parameter Object
 *
 * 파라미터 객체 만들기
 */
public class IntroduceParameterObject {

    static class Old {
        public List<Reading> readingsOutsideRange(Station station, int min, int max) {
            return station.readings.stream()
                    .filter(r -> r.temp < min || r.temp > max)
                    .collect(Collectors.toList());
        }
    }

    static class New {
        public List<Reading> readingsOutsideRange(Station station, NumberRange range) {
            return station.readings.stream()
                    //.filter(r -> r.temp < range.min || r.temp > range.max)
                    .filter(r -> !range.contains(r.temp))
                    .collect(Collectors.toList());
        }

        /**
         * 이렇게 클래스로 만들어두면, 관련 동작을 이 클래스로 옮길 수 있다.
         */
        static class NumberRange {
            int min;
            int max;

            public boolean contains(int number) {
                return number >= min && number <= max;
            }
        }

    }

    static class Station {
        String name;
        List<Reading> readings;
    }

    static class Reading {
        int temp;
        String time;
    }
}
