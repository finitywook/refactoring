package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Change Method Declaration(Change Function Declaration)
 *
 * 메서드 선언 바꾸기
 */
public class ChangeMethodDeclaration {

    public static final List<Integer> reservation = new ArrayList<>();

    static class Old {

        // 메서드 이름 바꾸기
        public double circum(double radius) {
            return 2 * Math.PI * radius;
        }
        // 메서드 이름 바꾸기

        // 매개변수 추가하기
        public void addReservation(int customer) {
            reservation.add(customer);
        }
        // 매개변수 추가히기

        // 매개변수를 속성으로 변경하기
        public boolean isNewEngland(Customer customer) {
            return Arrays.asList("MA", "CT", "ME", "VT").contains(customer.state);
        }
        // 매개변수를 속성으로 변경하기
    }

    static class New {

        // 메서드 이름 바꾸기
        @Deprecated // 삭제되었음을 알리기!
        public double circum(double radius) {
            return circumference(radius);
        }

        public double circumference(double radius) {
            return 2 * Math.PI * radius;
        }
        // 메서드 이름 바꾸기

        // 매개변수 추가하기
        public void addReservation(int customer) {
            addReservation(customer, false);
        }

        public void addReservation(int customer, boolean isPriority) {
            reservation.add(customer);
        }
        // 매개변수 추가히기

        // 매개변수를 속성으로 변경하기
        public boolean isNewEngland(String state) {
            return Arrays.asList("MA", "CT", "ME", "VT").contains(state);
        }
        // 매개변수를 속성으로 변경하기
    }

    static class Customer {
        String state;
    }
}
