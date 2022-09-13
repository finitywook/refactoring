package api;

/**
 * Replace Commend With Method
 *
 * 명령을 메서드로 바꾸기
 */
public class ReplaceCommendWithMethod {

    static class Old {
        static class ChargeCalculator {
            private Customer customer;
            private int usage;
            private Provider provider;

            public ChargeCalculator(Customer customer, int usage, Provider provider) {
                this.customer = customer;
                this.usage = usage;
                this.provider = provider;
            }

            private int baseCharge() {
                return customer.baseRate * usage;
            }

            public int charge() {
                return baseCharge() + provider.connectionCharge;
            }
        }
    }

    static class New {
        public int charge(Customer customer, int usage, Provider provider) {
            int baseCharge = customer.baseRate * usage;
            return baseCharge + provider.connectionCharge;
        }
    }

    static class Customer {
        int baseRate;
    }

    static class Provider {
        int connectionCharge;
    }
}
