package organizing;

/**
 * Split Variable
 *
 * 변수 쪼개기
 */
public class SplitVariable {

    static class Old {
        public double distanceTravelled(Scenario scenario,  int time) {
            double result;

            double acc = scenario.primaryForce / scenario.mass; // 가속도 = 힘 / 질량
            int primaryTime = Math.min(time, scenario.delay);

            result = 0.5 * acc * primaryTime * primaryTime; // 전파거리

            double secondaryTime = time - scenario.delay;

            if(secondaryTime > 0) {
                double primaryVelocity = acc * scenario.delay;
                acc = (scenario.primaryForce + scenario.primaryForce) / scenario.mass;
                result += primaryVelocity * secondaryTime + 0.5 * acc * secondaryTime * secondaryTime;
            }

            return result;
        }
    }

    static class New {
        public double distanceTravelled(Scenario scenario,  int time) {
            double result;

            final double primaryAcceleration = scenario.primaryForce / scenario.mass; // 가속도 = 힘 / 질량
            int primaryTime = Math.min(time, scenario.delay);

            result = 0.5 * primaryAcceleration * primaryTime * primaryTime; // 전파거리

            double secondaryTime = time - scenario.delay;

            if(secondaryTime > 0) {
                double primaryVelocity = primaryAcceleration * scenario.delay;
                final double secondaryAcceleration = (scenario.primaryForce + scenario.primaryForce) / scenario.mass;
                result += primaryVelocity * secondaryTime + 0.5 * secondaryAcceleration * secondaryTime * secondaryTime;
            }

            return result;
        }
    }

    static class Scenario {
        double primaryForce;
        double mass;
        int delay;

        public Scenario(double primaryForce, double mass, int delay) {
            this.primaryForce = primaryForce;
            this.mass = mass;
            this.delay = delay;
        }
    }
}
