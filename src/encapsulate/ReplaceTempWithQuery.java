package encapsulate;

/**
 * Replace Temp With Query
 *
 * 임시 변수를 질의 함수로 바꾸기
 */
public class ReplaceTempWithQuery {

    static class Old {
        static class Order {
            int quantity;
            int itemPrice;

            public int getPrice() {
                int basePrice = quantity * itemPrice;
                double discountFactor = 0.98;

                if(basePrice > 1000) discountFactor -= 0.03;
                return (int)(basePrice * discountFactor);
            }
        }

    }

    static class New {
        static class Order {
            int quantity;
            int itemPrice;

            public int getBasePrice() {
                return this.quantity * this.itemPrice;
            }

            public double getDiscountFactor() {
                double discountFactor = 0.98;
                if(this.getBasePrice() > 1000) discountFactor -= 0.03;
                return discountFactor;
            }

            public int getPrice() {
                return (int)(this.getBasePrice() * this.getDiscountFactor());
            }
        }
    }



}
