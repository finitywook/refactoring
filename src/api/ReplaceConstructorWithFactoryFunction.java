package api;

/**
 * Replace Constructor With Factory Function
 *
 * 생성자를 팩터리 함수로 바꾸기
 */
public class ReplaceConstructorWithFactoryFunction {

    static class Old {
        public static void main(String[] args) {
            Employee employee = new Employee("Ryu", "E");

            // action
        }
    }

    static class New {
        public static void main(String[] args) {
            Employee employee = createEmployee("Ryu", "E");

            // action
        }

        public static Employee createEmployee(String name, String typeCode) {
            return new Employee(name, typeCode);
        }
    }

    static class Employee {
        private final String name;
        private final String typeCode;

        public Employee(String name, String typeCode) {
            this.name = name;
            this.typeCode = typeCode;
        }

        public String getName() {
            return name;
        }

        public String getTypeCode() {
            return typeCode;
        }
    }
}
