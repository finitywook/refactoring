package basic;


/**
 * Inline Method(Inline Function)
 *
 * 함수를 인라인하기
 */
public class InlineMethod {

    static class Old {
        public int getRating(int numberOfLateDeliveries) {
            return moreThanFiveLateDeliveries(numberOfLateDeliveries) ? 2 : 1;
        }

        public boolean moreThanFiveLateDeliveries(int numberOfLateDeliveries) {
            return numberOfLateDeliveries > 5;
        }
    }

    static class New {
        public int getRating(int numberOfLateDeliveries) {
            return numberOfLateDeliveries > 5 ? 2 : 1;
        }
    }
}
