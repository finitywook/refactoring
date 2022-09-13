package extend;

/**
 * Pull Up Constructor Body
 *
 * 생성자 본문 올리기
 */
public class PullUpConstructorBody {

    static class Old {
        static class Party {
        }

        static class Employee extends Party {
            private int id;
            private String name;
            private int monthlyCost;

            public Employee(int id, String name, int monthlyCost) {
                super();
                this.id = id;
                this.name = name;
                this.monthlyCost = monthlyCost;
            }
        }

        static class Department extends Party {
            private String name;
            private boolean isStaff;

            public Department(String name, boolean isStaff) {
                super();
                this.name = name;
                this.isStaff = isStaff;
            }
        }
    }

    static class New {
        static class Party {
            private String name;

            public Party(String name) {
                this.name = name;
            }
        }

        static class Employee extends Party {
            private int id;
            private int monthlyCost;

            public Employee(int id, String name, int monthlyCost) {
                super(name);
                this.id = id;
                this.monthlyCost = monthlyCost;
            }
        }

        static class Department extends Party {
            private boolean isStaff;

            public Department(String name, boolean isStaff) {
                super(name);
                this.isStaff = isStaff;
            }
        }
    }
}
