package basic;

/**
 * Inline Variable
 *
 * 변수 인라인
 */
public class InlineVariable {

    static class Old {

        public boolean moreThanOneThousandBasePrice(Order order) {
            int baseAmount = order.basePrice;
            return baseAmount > 1000;
        }
    }

    static class New {
        public boolean moreThanOneThousandBasePrice(Order order) {
            return order.basePrice > 1000;
        }
    }

    static class Order {
        int basePrice;
    }
}
