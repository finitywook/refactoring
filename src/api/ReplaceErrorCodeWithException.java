package api;

import java.util.Arrays;

/**
 * Replace Error Code With Exception
 *
 * 오류 코드를 예외로 바꾸기
 */
public class ReplaceErrorCodeWithException {

    static class Old {
        public int localShippingRules(String country) {
            if(Arrays.asList("NA", "SU").contains(country)) {
                return 0;
            }

            return -23;
        }
    }

    static class New {
        public int localShippingRules(String country) {
            if(Arrays.asList("NA", "SU").contains(country)) {
                return 0;
            }

            throw new OrderException();
        }


        static class OrderException extends RuntimeException {
        }
    }
}
