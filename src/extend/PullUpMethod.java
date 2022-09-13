package extend;

/**
 * Pull Up Method
 *
 * 메서드 올리기
 */
public class PullUpMethod {

    static class Old {
        static class Employee extends Party {
            public int getAnnualCost() {
                return this.monthlyCost * 12;
            }
        }

        static class Department extends Party {
            public int totalAnnualCost() {
                return this.monthlyCost * 12;
            }
        }

        static class Party {
            int monthlyCost;
        }
    }

    static class New {
        static class Employee extends Party {
            @Deprecated
            public int getAnnualCost() {
                return super.annualCost();
            }
        }

        static class Department extends Party {
            @Deprecated
            public int totalAnnualCost() {
                return super.annualCost();
            }
        }

        static class Party {
            int monthlyCost;

            public int annualCost() {
                return this.monthlyCost * 12;
            }
        }
    }


}
