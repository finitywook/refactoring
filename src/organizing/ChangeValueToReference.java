package organizing;

import java.util.HashMap;
import java.util.Map;

/**
 * Change Value To Reference
 *
 * 값을 참조로 바꾸기
 */
public class ChangeValueToReference {

    static class Old {
        Customer customer;
        int price;

        public Old(int customerId, int price) {
            this.customer = new Customer(customerId); // 값, 항상 다른것을 참조
            this.price = price;
        }
    }

    static class New {
        Customer customer;
        int price;

        public New(int customerId, int price) {
            CustomerRepository customerRepository = new CustomerRepository();

            this.customer = customerRepository.findById(customerId); // 참조, 항상 같은것을 참조
            this.price = price;
        }
    }

    static class CustomerRepository {
        private final static Map<Integer, Customer> store = new HashMap<>();

        public Customer findById(int id) {
            return store.get(id);
        }

        public void save(Customer customer) {
            store.put(customer.id, customer);
        }
    }

    static class Customer {
        int id;
        String name;

        public Customer(int id) {
            this.id = id;
        }

        public Customer(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
