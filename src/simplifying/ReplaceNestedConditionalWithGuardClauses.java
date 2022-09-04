package simplifying;

/**
 * Replace Nested Conditional With Guard Clauses
 *
 * 중첩 조건문을 보호 구문으로 바꾸기
 */
public class ReplaceNestedConditionalWithGuardClauses {

    static class Old {
        public Pay payAmount(Employee employee) {
            Pay result;

            if(employee.isSeparated) {
                result = new Pay(0, "SEP");
            } else {
                if(employee.isRetired) {
                    result = new Pay(0, "RET");
                } else {
                    int amount = 20000;

                    // calculate pay amount

                    result = new Pay(amount, "SEP");
                }
            }

            return result;
        }
    }

    static class New {
        public Pay payAmount(Employee employee) {
            if(employee.isSeparated) {
                return new Pay(0, "SEP");
            }

            if(employee.isRetired) {
                return new Pay(0, "RET");
            }

            int amount = 20000;

            // calculate pay amount

            return new Pay(amount, "SEP");
        }
    }

    static class Pay {
        int amount;
        String reason;

        public Pay(int amount, String reason) {
            this.amount = amount;
            this.reason = reason;
        }
    }

    static class Employee {
        boolean isSeparated;
        boolean isRetired;
    }
}
