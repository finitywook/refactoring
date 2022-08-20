package encapsulate;

import java.util.Arrays;

/**
 * Substitute Algorithm
 *
 * 알고리즘 교체하기
 */
public class SubstituteAlgorithm {

    static class Old {
        public String findPerson(String[] names) {

            for(int i = 0; i < names.length; i++) {
                if("Don".equals(names[i])) {
                    return "Don";
                }

                if("John".equals(names[i])) {
                    return "John";
                }

                if("Kent".equals(names[i])) {
                    return "Kent";
                }
            }

            return "";
        }
    }

    static class New {
        public String findPerson(String[] names) {
            String[] persons = {"Don", "John", "Kent"};

            return Arrays.stream(names)
                    .filter(x -> Arrays.asList(persons).contains(x))
                    .findFirst().orElse("");
        }
    }
}
