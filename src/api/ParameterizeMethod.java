package api;

/**
 * Parameterize Method
 *
 * 메서드 매개변수화하기
 */
public class ParameterizeMethod {

    static class Old {
        public void tenPercentRaise(Person person) {
            person.salary = (int)(person.salary * 1.1);
        }

        public void fivePercentRaise(Person person) {
            person.salary = (int)(person.salary * 1.05);
        }
    }

    static class New {
        public void raise(Person person, double factor) {
            person.salary = (int)(person.salary * (1 + factor));
        }
    }

    static class Person {
        int salary;
    }
}
