package extend;

/**
 * Remove Subclass
 *
 * 서브클래스 제거하기
 */
public class RemoveSubclass {

    static class Old {
        static class Person {
            private String name;

            public Person(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }

            public String getGenderCode() {
                return "X";
            }

            public boolean isMale() {
                return false;
            }

            public boolean isFemale() {
                return false;
            }
        }

        static class Male extends Person {
            public Male(String name) {
                super(name);
            }

            @Override
            public String getGenderCode() {
                return "M";
            }

            @Override
            public boolean isMale() {
                return true;
            }
        }

        static class Female extends Person {
            public Female(String name) {
                super(name);
            }

            @Override
            public String getGenderCode() {
                return "F";
            }

            @Override
            public boolean isFemale() {
                return true;
            }
        }
    }

    static class New {
        static class Person {
            private String name;
            private String genderCode;

            @Deprecated
            public Person(String name) {
                this.name = name;
            }

            public Person(String name, String genderCode) {
                this.name = name;
                this.genderCode = genderCode;
            }

            public String getName() {
                return name;
            }

            public String getGenderCode() {
                return genderCode;
            }

            public boolean isMale() {
                return "M".equals(genderCode);
            }

            public boolean isFemale() {
                return "F".equals(genderCode);
            }
        }
    }
}
