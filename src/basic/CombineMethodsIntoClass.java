package basic;

/**
 * Combine Methods Into Class(Combine Functions Into Class)
 *
 * 여러 함수를 클래스로 묶기
 */
public class CombineMethodsIntoClass {

    static class Old {

        public static void main(String[] args) {
            Tax tax = new Tax(100000, 0.11);

            base(tax);
        }

        public static int base(Tax tax) {
            return (int) (tax.origin * tax.tariff);
        }
    }

    static class New {
        public static void main(String[] args) {
            Reading reading = new Reading(new Tax(100000, 0.11));

            reading.base();
        }

        static class Reading {
            Tax tax;

            public Reading(Tax tax) {
                this.tax = tax;
            }

            public int base() {
                return (int) (this.tax.origin * this.tax.tariff);
            }
        }
    }

    static class Tax {
        public Tax(int origin, double tariff) {
            this.origin = origin;
            this.tariff = tariff;
        }

        int origin;
        double tariff;
    }
}
