package simplifying;

/**
 * Introduce Special Case
 *
 * 특이 케이스 추가하기
 */
public class IntroduceSpecialCase {

    static class Old {
        public void client(Site site) {
            Customer customer = site.getCustomer();

            String customerName;

            if("미확인 고객".equals(customer.getName())) {
                customerName = "거주자";
            } else {
                customerName = customer.getName();
            }

            System.out.println("customerName = " + customerName);
        }
    }

    static class New {
        public void client(Site site) {
            Customer customer = site.getCustomer();

            System.out.println("customerName = " + customer.getName());
        }
    }

    static class UnknownCustomer extends Customer {
        public UnknownCustomer() {
            super(null, null);
        }

        @Override
        public String getName() {
            return "거주자";
        }

        public boolean isUnknown() {
            return true;
        }
    }

    static class Site {
        private Customer customer;

        public Site(Customer customer) {
            if("미확인 고객".equals(customer.name)) {
                this.customer = new UnknownCustomer();
            } else {
                this.customer = customer;
            }
        }

        public Customer getCustomer() {
            return customer;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }
    }

    static class Customer {
        private String name;
        private String billingPlan;

        public Customer(String name, String billingPlan) {
            this.name = name;
            this.billingPlan = billingPlan;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBillingPlan() {
            return billingPlan;
        }

        public void setBillingPlan(String billingPlan) {
            this.billingPlan = billingPlan;
        }

        public boolean isUnknown() {
            return false;
        }
    }
}
