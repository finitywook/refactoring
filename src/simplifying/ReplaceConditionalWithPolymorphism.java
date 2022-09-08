package simplifying;

/**
 * Replace Conditional With Polymorphism
 *
 * 조건부 로직을 다형성으로 바꾸기
 */
public class ReplaceConditionalWithPolymorphism {

    static class Old {
        public String plumage(Bird bird) {
            switch (bird.type) {
                case "제비":
                    return "보통";
                case "앵무":
                    return bird.numberOfCoconuts > 2 ? "지침" : "보통";
                default:
                    return "알 수 없음";
            }
        }

        public Integer airSpeedVelocity(Bird bird) {
            switch (bird.type) {
                case "제비":
                    return 35;
                case "앵무":
                    return 40 - 2 * bird.numberOfCoconuts;
                default:
                    return null;
            }
        }

        static class Bird {
            String name;
            String type;
            int numberOfCoconuts;
            int voltage;
        }
    }

    static class New {

        public Bird createBird(String name, String type, int numberOfCoconuts, int voltage) {
            switch (type) {
                case "제비":
                    return new Swallow(name, type, numberOfCoconuts, voltage);
                case "앵무":
                    return new Parrot(name, type, numberOfCoconuts, voltage);
                default:
                    return new Bird(name, type, numberOfCoconuts, voltage);
            }
        }

        public String plumage(String name, String type, int numberOfCoconuts, int voltage) {
            return createBird(name, type, numberOfCoconuts, voltage).plumage();
        }

        public Integer airSpeedVelocity(String name, String type, int numberOfCoconuts, int voltage) {
            return createBird(name, type, numberOfCoconuts, voltage).airSpeedVelocity();
        }

        static class Bird {
            String name;
            String type;
            int numberOfCoconuts;
            int voltage;

            public Bird(String name, String type, int numberOfCoconuts, int voltage) {
                this.name = name;
                this.type = type;
                this.numberOfCoconuts = numberOfCoconuts;
                this.voltage = voltage;
            }

            public String plumage() {
                return "알 수 없음";
            }

            public Integer airSpeedVelocity() {
                return null;
            }
        }

        static class Swallow extends Bird {
            public Swallow(String name, String type, int numberOfCoconuts, int voltage) {
                super(name, type, numberOfCoconuts, voltage);
            }

            @Override
            public String plumage() {
                return "보통";
            }

            @Override
            public Integer airSpeedVelocity() {
                return 35;
            }
        }

        static class Parrot extends Bird {
            public Parrot(String name, String type, int numberOfCoconuts, int voltage) {
                super(name, type, numberOfCoconuts, voltage);
            }

            @Override
            public String plumage() {
                return numberOfCoconuts > 2 ? "지침" : "보통";
            }

            @Override
            public Integer airSpeedVelocity() {
                return 40 - 2 * numberOfCoconuts;
            }
        }
    }


}
