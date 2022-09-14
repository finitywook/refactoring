package extend;

import java.util.List;

/**
 * Extract Superclass
 *
 * 슈퍼클래스 추출하기
 */
public class ExtractSuperclass {

    static class Old {
        static class Employee {
            private final String name;
            private final String id;
            private final int monthlyCost;

            public Employee(String name, String id, int monthlyCost) {
                this.name = name;
                this.id = id;
                this.monthlyCost = monthlyCost;
            }

            public String getName() {
                return name;
            }

            public String getId() {
                return id;
            }

            public int getMonthlyCost() {
                return monthlyCost;
            }

            public int getAnnualCost() {
                return monthlyCost * 12;
            }
        }

        static class Department {
            private final String name;
            private final List<Employee> staffs;

            public Department(String name, List<Employee> staffs) {
                this.name = name;
                this.staffs = staffs;
            }

            public String getName() {
                return name;
            }

            public List<Employee> getStaffs() {
                return staffs;
            }

            public int getTotalMonthlyCost() {
                return this.staffs.stream()
                        .mapToInt(Employee::getMonthlyCost)
                        .sum();
            }

            public int getHeadCount() {
                return this.staffs.size();
            }

            public int getAnnualCost() {
                return getTotalMonthlyCost() * 12;
            }
        }
    }

    static class New {
        static class Party {
            private final String name;

            public Party(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }

            public int getMonthlyCost() {
                throw new RuntimeException();
            }

            public int getAnnualCost() {
                return getMonthlyCost() * 12;
            }
        }

        static class Employee extends Party {
            private final String id;
            private final int monthlyCost;

            public Employee(String name, String id, int monthlyCost) {
                super(name);
                this.id = id;
                this.monthlyCost = monthlyCost;
            }

            public String getId() {
                return id;
            }

            @Override
            public int getMonthlyCost() {
                return monthlyCost;
            }
        }

        static class Department extends Party {
            private final List<Employee> staffs;

            public Department(String name, List<Employee> staffs) {
                super(name);
                this.staffs = staffs;
            }

            public List<Employee> getStaffs() {
                return staffs;
            }

            @Override
            public int getMonthlyCost() {
                return this.staffs.stream()
                        .mapToInt(Employee::getMonthlyCost)
                        .sum();
            }

            public int getHeadCount() {
                return this.staffs.size();
            }
        }
    }
}
