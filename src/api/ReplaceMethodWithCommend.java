package api;

/**
 * Replace Method With Commend
 *
 * 메서드를 명령으로 바꾸기
 */
public class ReplaceMethodWithCommend {

    static class Old {
        public int score(String originState, boolean isSmoker) {
            int result = 0;
            int healthLevel = 0;
            boolean highMedicalRiskFlag = false;

            if(isSmoker) {
                healthLevel += 10;
                highMedicalRiskFlag = true;
            }

            // 비슷한 코드...

            result -= Math.max(healthLevel - 5, 0);

            return result;
        }
    }

    static class New {

        static class Scorer {
            private String originState;
            private boolean isSmoker;

            public Scorer(String originState, boolean isSmoker) {
                this.originState = originState;
                this.isSmoker = isSmoker;
            }

            public int execute() {
                int result = 0;
                int healthLevel = 0;
                boolean highMedicalRiskFlag = false;

                if(isSmoker) {
                    healthLevel += 10;
                    highMedicalRiskFlag = true;
                }

                // 비슷한 코드...

                result -= Math.max(healthLevel - 5, 0);

                return result;
            }
        }

    }
}
