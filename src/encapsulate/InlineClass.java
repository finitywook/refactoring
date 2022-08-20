package encapsulate;

/**
 * Inline Class
 *
 * 클래스 인라인하기
 */
public class InlineClass {

    static class Old {
        static class Person {
            private String name;
            private Telephone officeNumber;

            public Person(String name, Telephone officeNumber) {
                this.name = name;
                this.officeNumber = officeNumber;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTelephoneNumber() {
                return officeNumber.toString();
            }

            public String getOfficeAreaCode() {
                return officeNumber.getAreaCode();
            }

            public String getOfficeNumber() {
                return officeNumber.getNumber();
            }
        }

        static class Telephone {
            private String areaCode;
            private String number;

            public String getAreaCode() {
                return areaCode;
            }

            public void setAreaCode(String areaCode) {
                this.areaCode = areaCode;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            @Override
            public String toString() {
                return "(" + areaCode + ")" + number;
            }
        }
    }

    static class New {
        static class Person {
            private String name;
            private String officeAreaCode;
            private String officeNumber;

            public Person(String name, String officeAreaCode, String officeNumber) {
                this.name = name;
                this.officeAreaCode = officeAreaCode;
                this.officeNumber = officeNumber;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTelephoneNumber() {
                return "(" + officeAreaCode + ")" + officeNumber;
            }

            public String getOfficeAreaCode() {
                return officeAreaCode;
            }

            public void setOfficeAreaCode(String officeAreaCode) {
                this.officeAreaCode = officeAreaCode;
            }

            public String getOfficeNumber() {
                return officeNumber;
            }

            public void setOfficeNumber(String officeNumber) {
                this.officeNumber = officeNumber;
            }
        }
    }
}
