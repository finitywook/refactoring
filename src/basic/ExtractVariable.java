package basic;

/**
 * Extract Variable
 *
 * 변수 추출하기
 */
public class ExtractVariable {

    static class Old {
        public double getAmount(Order order) {
            return order.quantity * order.itemPrice - Math.max(0, order.quantity - 500)
                    * order.itemPrice * 0.05 + Math.min(order.quantity * order.itemPrice * 0.1, 100);
        }
    }

    static class New {
        public double getAmount(Order order) {
            // 변수 추출
            int basePrice = order.quantity * order.itemPrice;
            double quantityDiscount = Math.max(0, order.quantity - 500)
                    * order.itemPrice * 0.05;
            double shipping = Math.min(order.quantity * order.itemPrice * 0.1, 100);
            return basePrice - quantityDiscount + shipping;
        }
    }

    static class Order {
        int itemPrice;
        int quantity;

        public Order(int itemPrice, int quantity) {
            this.itemPrice = itemPrice;
            this.quantity = quantity;
        }
    }
}
