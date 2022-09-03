package move;

import java.util.List;

/**
 * Split Loop
 *
 * 반복문 쪼개기
 */
public class SplitLoop {

    static class Old {
        public void printPeoplesInfo(List<People> peoples) {
            int youngest = Integer.MAX_VALUE;
            int totalSalary = 0;

            for(People people : peoples) {
                if(people.age < youngest) {
                    youngest = people.age;
                }

                totalSalary += people.salary;
            }

            System.out.println("youngest : " + youngest + ", totalSalary : " + totalSalary);
        }
    }

    static class New {
        public void printPeoplesInfo(List<People> peoples) {
            System.out.println("youngest : " + getYoungest(peoples) + ", totalSalary : " + getTotalSalary(peoples));
        }

        private int getTotalSalary(List<People> peoples) {
            int result = 0;

            for(People people : peoples) {
                result += people.salary;
            }

            return result;
        }

        private int getYoungest(List<People> peoples) {
            int result = Integer.MAX_VALUE;

            for(People people : peoples) {
                if(people.age < result) {
                    result = people.age;
                }
            }

            return result;
        }
    }

    static class People {
        int age;
        int salary;
    }
}
