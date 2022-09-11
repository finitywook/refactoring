package api;

import java.util.stream.Stream;

/**
 * Remove Flag Argument
 *
 * 플래그 인수 제거하기
 */
public class RemoveFlagArgument {

    static class Old {
        public int deliveryTime(Order order, boolean isRush) {
            if(isRush) {
                int deliveryTime;

                if(Stream.of("MA", "CT").anyMatch(x -> x.equals(order.deliveryState))) {
                    deliveryTime = 1;
                } else if(Stream.of("NY", "NH").anyMatch(x -> x.equals(order.deliveryState))) {
                    deliveryTime = 2;
                } else {
                    deliveryTime = 3;
                }

                order.deliveryTime = deliveryTime;

                return deliveryTime;
            } else {
                int deliveryTime;

                if(Stream.of("MA", "CT", "NY").anyMatch(x -> x.equals(order.deliveryState))) {
                    deliveryTime = 1;
                } else if(Stream.of("ME", "NH").anyMatch(x -> x.equals(order.deliveryState))) {
                    deliveryTime = 2;
                } else {
                    deliveryTime = 3;
                }

                order.deliveryTime = deliveryTime;

                return deliveryTime;
            }
        }
    }

    static class New {
        private int rushDeliveryTime(Order order) {
            int deliveryTime;

            if(Stream.of("MA", "CT").anyMatch(x -> x.equals(order.deliveryState))) {
                deliveryTime = 1;
            } else if(Stream.of("NY", "NH").anyMatch(x -> x.equals(order.deliveryState))) {
                deliveryTime = 2;
            } else {
                deliveryTime = 3;
            }

            order.deliveryTime = deliveryTime;

            return deliveryTime;
        }

        private int regularDeliveryTime(Order order) {
            int deliveryTime;

            if(Stream.of("MA", "CT", "NY").anyMatch(x -> x.equals(order.deliveryState))) {
                deliveryTime = 1;
            } else if(Stream.of("ME", "NH").anyMatch(x -> x.equals(order.deliveryState))) {
                deliveryTime = 2;
            } else {
                deliveryTime = 3;
            }

            order.deliveryTime = deliveryTime;

            return deliveryTime;
        }
    }

    static class Order {
        String deliveryState;
        int deliveryTime;
    }
}
