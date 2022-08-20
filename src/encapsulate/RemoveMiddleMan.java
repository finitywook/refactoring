package encapsulate;

/**
 * Remove Middle Man
 *
 * 중개자 제거하기
 */
public class RemoveMiddleMan {

    static class Old {
        public void printDepartmentManager(Person person) {
            System.out.println("manager : " + person.getDepartmentManager());
        }

        static class Person {
            private String name;
            private Department department;

            public Person(String name, Department department) {
                this.name = name;
                this.department = department;
            }

            public String getName() {
                return name;
            }

            public Department getDepartment() {
                return department;
            }

            public String getDepartmentManager() {
                return this.department.getManager();
            }
        }

        static class Department {
            private String name;
            private String manager;

            public Department(String name, String manager) {
                this.name = name;
                this.manager = manager;
            }

            public String getName() {
                return name;
            }

            public String getManager() {
                return manager;
            }
        }
    }

    static class New {
        public void printDepartmentManager(Person person) {
            System.out.println("manager : " + person.getDepartment().getManager());
        }

        static class Person {
            private String name;
            private Department department;

            public Person(String name, Department department) {
                this.name = name;
                this.department = department;
            }

            public String getName() {
                return name;
            }

            public Department getDepartment() {
                return department;
            }
        }

        static class Department {
            private String name;
            private String manager;

            public Department(String name, String manager) {
                this.name = name;
                this.manager = manager;
            }

            public String getName() {
                return name;
            }

            public String getManager() {
                return manager;
            }
        }
    }
}
