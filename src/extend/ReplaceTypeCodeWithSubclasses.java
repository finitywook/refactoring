package extend;

import java.util.Arrays;

/**
 * Replace Type Code With Subclasses
 *
 * 타입 코드를 서브 클래스로 바꾸기
 */
public class ReplaceTypeCodeWithSubclasses {

    static class Old {
        static class Employee {
            private String type;
            private String name;

            public Employee(String type, String name) {
                validateType(type);
                this.type = type;
                this.name = name;
            }

            public void validateType(String arg) {
                if(!Arrays.asList("manager", "engineer", "salesperson").contains(arg)) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    static class New {
        public Employee createEmployee(String name, String type) {
            switch (type) {
                case "engineer":
                    return new Engineer(name);
                case "manager":
                    return new Manager(name);
                case "salesperson":
                    return new SalesPerson(name);
                default:
                    throw new IllegalArgumentException();
            }
        }

        static class Employee {
            private String name;

            public Employee(String name) {
                this.name = name;
            }

            public void validateType(String arg) {
                if(!Arrays.asList("manager", "engineer", "salesperson").contains(arg)) {
                    throw new IllegalArgumentException();
                }
            }
        }

        static class Engineer extends Employee {
            public Engineer(String name) {
                super(name);
            }

            public String getType() {
                return "engineer";
            }
        }

        static class Manager extends Employee {
            public Manager(String name) {
                super(name);
            }

            public String getType() {
                return "manager";
            }
        }

        static class SalesPerson extends Employee {
            public SalesPerson(String name) {
                super(name);
            }

            public String getType() {
                return "salesperson";
            }
        }
    }
}
