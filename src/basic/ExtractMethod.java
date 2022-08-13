package basic;

/**
 * Extract Method(Extract Function)
 *
 * 함수를 추출하기
 */
public class ExtractMethod {
    public static int add(int a, int b) {
        return a + b;
    }

    static class Old {
        public void printSummary(String name) {
            int sum = add(10, 20);

            System.out.println("name = " + name);
            System.out.println("sum = " + sum);
        }
    }

    static class New {
        public void printSummary(String name) {
            int sum = add(10, 20);

            printDetails(name, sum); // 메서드를 분리!
        }

        private void printDetails(String name, int sum) {
            System.out.println("name = " + name);
            System.out.println("sum = " + sum);
        }
    }
}