package simplifying;

import java.time.LocalDate;

/**
 * Decompose Conditional
 *
 * 조건문 분해하기
 */
public class DecomposeConditional {

    static class Old {
        public int calculateCharge(Plan plan, int quantity) {
            int result = 0;

            LocalDate now = LocalDate.now();

            if(!now.isBefore(plan.summerStart) && !now.isAfter(plan.summerEnd)) {
                result = quantity * plan.summerRate;
            } else {
                result = quantity * plan.regularRate * plan.regularServiceCharge;
            }

            return result;
        }
    }

    static class New {
        public int calculateCharge(Plan plan, int quantity) {
            return summer(plan) ? summerCharge(plan, quantity) : regularCharge(plan, quantity);
        }

        private int regularCharge(Plan plan, int quantity) {
            return quantity * plan.regularRate * plan.regularServiceCharge;
        }

        private int summerCharge(Plan plan, int quantity) {
            return quantity * plan.summerRate;
        }

        private boolean summer(Plan plan) {
            LocalDate now = LocalDate.now();

            return !now.isBefore(plan.summerStart) && !now.isAfter(plan.summerEnd);
        }
    }

    static class Plan {
        LocalDate summerStart;
        LocalDate summerEnd;
        int summerRate;
        int regularRate;
        int regularServiceCharge;
    }
}
