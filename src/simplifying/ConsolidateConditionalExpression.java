package simplifying;

/**
 * Consolidate Conditional Expression
 *
 * 조건식 통합하기
 */
public class ConsolidateConditionalExpression {

    static class Old {
        public int disabilityAmount(Employee employee) {
            int result = 0; // temp

            if(employee.seniority < 2) {
                return 0;
            }

            if(employee.monthsDisabled < 12) {
                return 0;
            }

            if(employee.isPartTime) {
                return 0;
            }

            // calculate logic ....

            return result;
        }
    }

    static class New {
        public int disabilityAmount(Employee employee) {
            int result = 0;

            if(isNotEligibleForDisability(employee)) {
                return 0;
            }

            // calculate logic ....

            return result;
        }

        private boolean isNotEligibleForDisability(Employee employee) {
            return (employee.seniority < 2)
                || (employee.monthsDisabled < 12)
                || (employee.isPartTime);
        }
    }

    static class Employee {
        int seniority;
        int monthsDisabled;
        boolean isPartTime;
    }
}
