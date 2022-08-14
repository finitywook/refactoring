package basic;

/**
 * Encapsulate Variable
 *
 * 변수 캡슐화하기
 */
public class EncapsulateVariable {

    static class Old {
        public static final Old defaultOwner = new Old("Ryu", "HanWook");

        String firstName;
        String lastName;

        public Old(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    static class New {
        private static final New defaultOwner = new New("Ryu", "HanWook");

        private String firstName;
        private String lastName;

        public New(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public static New getDefaultOwner() {
            return defaultOwner;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }
}
