package move;

/**
 * Move Field
 *
 * 필드 옮기기
 */
public class MoveField {

    static class Old {
        static class Customer {
            private String name;
            private double discountRate;
            private CustomerContract contract;

            public Customer(String name, double discountRate, CustomerContract contract) {
                this.name = name;
                this.discountRate = discountRate;
                this.contract = contract;
            }

            public double getDiscountRate() {
                return discountRate;
            }

            public void becomePreferred() {
                this.discountRate += 0.03;
            }

            public double applyDiscount(int amount) {
                return amount - (amount / this.discountRate);
            }
        }

        static class CustomerContract {
            private String startDate;

            public CustomerContract(String startDate) {
                this.startDate = startDate;
            }
        }
    }

    static class New {
        static class Customer {
            private String name;
            private CustomerContract contract;

            public Customer(String name, double discountRate) {
                this.name = name;
                this.contract = new CustomerContract("test", discountRate);
                setDiscountRate(discountRate);
            }

            public void setDiscountRate(double discountRate) {
                this.contract.setDiscountRate(discountRate);
            }

            public double getDiscountRate() {
                return this.contract.getDiscountRate();
            }

            public void becomePreferred() {
                setDiscountRate(getDiscountRate() + 0.03);
            }

            public double applyDiscount(int amount) {
                return amount - (amount / this.getDiscountRate());
            }
        }

        static class CustomerContract {
            private String startDate;
            private double discountRate;

            public CustomerContract(String startDate, double discountRate) {
                this.startDate = startDate;
                this.discountRate = discountRate;
            }

            public double getDiscountRate() {
                return discountRate;
            }

            public void setDiscountRate(double discountRate) {
                this.discountRate = discountRate;
            }
        }
    }
}
