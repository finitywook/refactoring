package basic;

/**
 * Combine Methods Into Transform(Combine Functions Into Transform)
 *
 * 여러 메서드를 변환 메서드로 묶기
 */
public class CombineMethodsIntoTransform {

    static class Old {
        public static void main(String[] args) {
            Tax tax = new Tax(100000, 0.11);

            System.out.println(base(tax));
        }

        public static int base(Tax tax) {
            return (int) (tax.origin * tax.tariff);
        }

    }

    static class New {
        public static void main(String[] args) throws CloneNotSupportedException {
            Tax tax = new Tax(100000, 0.11);
            Tax newTax = enrichReading(tax);

            System.out.println(newTax.base);
        }

        public static Tax enrichReading(Tax original) throws CloneNotSupportedException {
            Tax result = (Tax) original.clone();

            result.base = (int) (result.origin * result.tariff);

            return result;
        }
    }

    static class Tax implements Cloneable {
        public Tax(int origin, double tariff) {
            this.origin = origin;
            this.tariff = tariff;
        }

        int origin;
        double tariff;
        int base;

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
