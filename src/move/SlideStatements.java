package move;

/**
 * Slide Statements
 *
 * 문장 슬라이드 하기
 */
public class SlideStatements {

    static class Old {
        public Order createOrder() {
            int orderNo = 10;
            String orderName = "주문";
            int deliveryNo = 30;
            int price = 3000;
            int fee = (int) (price * 0.97);
            int time = 300;

            Order order = new Order(orderNo, orderName, price);
            Delivery delivery = new Delivery(deliveryNo, orderNo, fee, time);

            return order;
        }
    }

    static class New {
        public Order createOrder() {
            int orderNo = 10;
            String orderName = "주문";
            int price = 3000;

            Order order = new Order(orderNo, orderName, price);

            int deliveryNo = 30;
            int fee = (int) (price * 0.97);
            int time = 300;

            Delivery delivery = new Delivery(deliveryNo, order.no, fee, time);

            return order;
        }
    }

    static class Order {
        int no;
        String name;
        int price;

        public Order(int no, String name, int price) {
            this.no = no;
            this.name = name;
            this.price = price;
        }
    }

    static class Delivery {
        int no;
        int orderNo;
        int fee;
        int time;

        public Delivery(int no, int orderNo, int fee, int time) {
            this.no = no;
            this.orderNo = orderNo;
            this.fee = fee;
            this.time = time;
        }
    }

}
