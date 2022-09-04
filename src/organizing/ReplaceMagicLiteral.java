package organizing;

/**
 * Replace Magic Literal
 *
 * 매직 리터럴 바꾸기
 */
public class ReplaceMagicLiteral {
    static class Old {
        public double potentialEnergy(double mass, double height) {
            return mass * 9.81 * height;
        }
    }

    static class New {
        private static final double STANDARD_GRAVITY = 9.81;

        public double potentialEnergy(double mass, double height) {
            return mass * STANDARD_GRAVITY * height;
        }
    }
}
