package api;

/**
 * Replace Parameter With Query
 *
 * 매개변수를 질의 함수로 바꾸기
 */
public class ReplaceParameterWithQuery {

    static class Old {
        int quantity;
        int itemPrice;

        public int getFinalPrice() {
            final int basePrice = this.quantity * this.itemPrice;

            int discountLevel;

            if(this.quantity > 100) {
                discountLevel = 2;
            } else {
                discountLevel = 1;
            }

            return this.getDiscountedPrice(basePrice, discountLevel);
        }

        private int getDiscountedPrice(int basePrice, int discountLevel) {
            switch (discountLevel) {
                case 1:
                    return (int)(basePrice * 0.95);
                case 2:
                    return (int)(basePrice * 0.9);
                default:
                    return basePrice;
            }
        }
    }

    static class New {
        int quantity;
        int itemPrice;

        public int getFinalPrice() {
            final int basePrice = this.quantity * this.itemPrice;

            return this.getDiscountedPrice(basePrice);
        }

        private int getDiscountLevel() {
            return this.quantity > 100 ? 2 : 1;
        }

        private int getDiscountedPrice(int basePrice) {
            switch (getDiscountLevel()) {
                case 1:
                    return (int)(basePrice * 0.95);
                case 2:
                    return (int)(basePrice * 0.9);
                default:
                    return basePrice;
            }
        }
    }
}
