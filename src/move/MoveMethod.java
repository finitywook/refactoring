package move;

/**
 * Move Method
 *
 * 메서드 이동하기
 */
public class MoveMethod {

    static class Old {
        static class Account {
            private String number;
            private AccountType type;
            private int daysOverDrawn;

            public Account(String number, AccountType type, int daysOverDrawn) {
                this.number = number;
                this.type = type;
                this.daysOverDrawn = daysOverDrawn;
            }

            public double overdraftCharge() {
                if(type.isPremium()) {
                    final int baseCharge = 10;

                    if(daysOverDrawn <= 7) {
                        return baseCharge;
                    } else {
                        return baseCharge + (daysOverDrawn - 7) * 0.85;
                    }
                }

                return daysOverDrawn * 1.75;
            }

            public String getNumber() {
                return number;
            }

            public AccountType getType() {
                return type;
            }

            public int getDaysOverDrawn() {
                return daysOverDrawn;
            }
        }

        static class AccountType {
            private String name;
            private boolean premium;

            public AccountType(String name, boolean premium) {
                this.name = name;
                this.premium = premium;
            }

            public String getName() {
                return name;
            }

            public boolean isPremium() {
                return premium;
            }
        }
    }

    static class New {
        static class Account {
            private String number;
            private AccountType type;
            private int daysOverDrawn;

            public Account(String number, AccountType type, int daysOverDrawn) {
                this.number = number;
                this.type = type;
                this.daysOverDrawn = daysOverDrawn;
            }

            public double overdraftCharge() {
                return type.overdraftCharge(daysOverDrawn);
            }

            public String getNumber() {
                return number;
            }

            public AccountType getType() {
                return type;
            }

            public int getDaysOverDrawn() {
                return daysOverDrawn;
            }
        }

        static class AccountType {
            private String name;
            private boolean premium;

            public AccountType(String name, boolean premium) {
                this.name = name;
                this.premium = premium;
            }

            public String getName() {
                return name;
            }

            public boolean isPremium() {
                return premium;
            }

            public double overdraftCharge(int daysOverDrawn) {
                if(premium) {
                    final int baseCharge = 10;

                    if(daysOverDrawn <= 7) {
                        return baseCharge;
                    } else {
                        return baseCharge + (daysOverDrawn - 7) * 0.85;
                    }
                }

                return daysOverDrawn * 1.75;
            }
        }
    }
}
