package extend;

/**
 * Pull Down Method
 *
 * 메서드 내리기
 */
public class PullDownMethod {

    static class Old {
        static class Employee {
            private int quota;

            public int getQuota() {
                return quota;
            }
        }

        static class Engineer extends Employee {
        }

        static class SalesPerson extends Employee {
        }
    }

    static class New {
        static class Employee {
        }

        static class Engineer extends Employee {
        }

        static class SalesPerson extends Employee {
            private int quota;

            public int getQuota() {
                return quota;
            }
        }
    }
}
