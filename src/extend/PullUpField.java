package extend;

/**
 * Pull Up Field
 *
 * 필드 올리기
 */
public class PullUpField {

    static class Old {
        static class Employee {

        }

        static class SalesPerson extends Employee {
            private String name;
        }

        static class Engineer extends Employee {
            private String name;
        }
    }

    static class New {
        static class Employee {
            protected String name;
        }

        static class SalesPerson extends Employee {
        }

        static class Engineer extends Employee {
        }
    }
}
