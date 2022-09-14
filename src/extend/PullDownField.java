package extend;

/**
 * Pull Down Field
 *
 * 필드 내리기
 */
public class PullDownField {

    static class Old {
        static class Employee {
            private String quota;
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
            private String quota;
        }
    }
}
