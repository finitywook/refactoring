package encapsulate;

import java.util.HashMap;
import java.util.Map;

/**
 * Encapsulate Record
 *
 * 레코드 캡슐화하기
 */
public class EncapsulateRecord {

    static class Old {
        public static void main(String[] args) {
            Map<String, String> map = new HashMap<>();

            map.put("name", "Ryu");
            map.put("country", "KR");

            printOrganization(map);
        }

        public static void printOrganization(Map<String, String> organization) {
            System.out.println("name = " + organization.get("name"));
            System.out.println("country = " + organization.get("country"));
        }
    }

    static class New {
        public static void main(String[] args) {
            Organization organization = new Organization("Ryu", "KR");

            printOrganization(organization); // 1
            organization.print(); // 2
        }

        public static void printOrganization(Organization organization) {
            System.out.println("name = " + organization.getName());
            System.out.println("country = " + organization.getCountry());
        }


        static class Organization {
            private String name;
            private String country;

            public Organization(String name, String country) {
                this.name = name;
                this.country = country;
            }

            public void print() {
                System.out.println("name = " + name);
                System.out.println("country = " + country);
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }
        }
    }
}
