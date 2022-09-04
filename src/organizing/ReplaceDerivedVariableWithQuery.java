package organizing;

import java.util.ArrayList;
import java.util.List;

/**
 * Replace Derived Variable With Query
 *
 * 파생 변수를 질의 함수로 바꾸기
 */
public class ReplaceDerivedVariableWithQuery {

    static class Old {
        private int production;
        private final List<Integer> adjustments = new ArrayList<>();

        public void applyAdjustment(int adjustment) {
            this.adjustments.add(adjustment);
            production += adjustment;
        }

        public int getProduction() {
            return production;
        }
    }

    static class New {
        private final List<Integer> adjustments = new ArrayList<>();

        public void applyAdjustment(int adjustment) {
            this.adjustments.add(adjustment);
        }

        public int getProduction() {
            return adjustments.stream()
                    .mapToInt(Integer::intValue)
                    .sum();
        }
    }
}
