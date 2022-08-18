package encapsulate;

/**
 * Replace Primitive With Object
 *
 * 기본형을 객체로 바꾸기
 */
public class ReplacePrimitiveWithObject {

    static class Old {
        static class Member {
            String name;
            String telephone;

            public String getTelephone() {
                return telephone;
            }
        }
    }

    static class New {
        static class Member {
            String name;
            Telephone telephone;

            public Telephone getTelephone() {
                return telephone;
            }

            static class Telephone {
                String number;

                public String pretty() {

                    // pretty logic

                    return number;
                }

                @Override
                public String toString() {
                    return number;
                }
            }
        }
    }
}
