package api;

import java.util.Arrays;
import java.util.List;

/**
 * Separate Query From Modifier
 *
 * 질의 함수와 변경 함수 분리하기
 */
public class SeparateQueryFromModifier {

    static class Old {

        public static void main(String[] args) {
            Old old = new Old();

            old.alertForMiscreant(Arrays.asList("조커", "사루만"));
        }

        public String alertForMiscreant(List<String> peoples) {
            for(String people : peoples) {
                if("조커".equals(people)) {
                    setOffAlarms();
                    return people;
                }

                if("사루만".equals(people)) {
                    setOffAlarms();
                    return people;
                }
            }

            return null;
        }

        public void setOffAlarms() {
        }
    }

    static class New {
        public static void main(String[] args) {
            New aNew = new New();

            aNew.findMiscreant(Arrays.asList("조커", "사루만"));
            aNew.alertForMiscreant(Arrays.asList("조커", "사루만"));
        }

        public void alertForMiscreant(List<String> peoples) {
            for(String people : peoples) {
                if("조커".equals(people)) {
                    setOffAlarms();
                    return;
                }

                if("사루만".equals(people)) {
                    setOffAlarms();
                    return;
                }
            }
        }

        public String findMiscreant(List<String> peoples) {
            for(String people : peoples) {
                if("조커".equals(people)) {
                    return people;
                }

                if("사루만".equals(people)) {
                    return people;
                }
            }

            return null;
        }

        public void setOffAlarms() {
        }
    }
}
