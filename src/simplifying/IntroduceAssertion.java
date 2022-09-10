package simplifying;

/**
 * Introduce Assertion
 *
 * 어서션 추가하기
 */
public class IntroduceAssertion {

    static class Old {
        public int applyDiscount(Integer discountRate, int price) {
            return discountRate != null ?
                    price - (discountRate * price) : price;
        }
    }

    static class New {
        public int applyDiscount(Integer discountRate, int price) {
            if (discountRate != null) {
                assert discountRate >= 0;
                return price - (discountRate * price);
            } else {
                return price;
            }
        }
    }
}
