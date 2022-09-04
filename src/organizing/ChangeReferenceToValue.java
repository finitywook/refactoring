package organizing;

/**
 * Change Reference To Value
 *
 * 참조를 값으로 바꾸기
 */
public class ChangeReferenceToValue {

    static class Old {
        Telephone telephoneNumber;

        public Old() {
            this.telephoneNumber = new Telephone();
        }

        public String getAreaCode() {
            return telephoneNumber.areaCode;
        }

        public void setAreaCode(String areaCode) {
            this.telephoneNumber.areaCode = areaCode;
        }

        public String getNumber() {
            return telephoneNumber.number;
        }

        public void setNumber(String number) {
            this.telephoneNumber.number = number;
        }
    }

    static class New {
        Telephone telephoneNumber;

        public New(String areaCode, String number) {
            this.telephoneNumber = new Telephone(areaCode, number);
        }

        public String getAreaCode() {
            return telephoneNumber.areaCode;
        }

        public void setAreaCode(String areaCode) {
            this.telephoneNumber = new Telephone(areaCode, this.getNumber());
        }

        public String getNumber() {
            return telephoneNumber.number;
        }

        public void setNumber(String number) {
            this.telephoneNumber = new Telephone(this.getAreaCode(), number);
        }
    }

    static class Telephone {
        String areaCode;
        String number;

        public Telephone() {
        }

        public Telephone(String areaCode, String number) {
            this.areaCode = areaCode;
            this.number = number;
        }
    }
}
