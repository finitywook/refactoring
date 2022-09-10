package simplifying;

import java.util.List;

/**
 * Replace Control Flag With Break
 *
 * 제어 플래그를 탈출문으로 바꾸기
 */
public class ReplaceControlFlagWithBreak {

    static class Old {
        public void checkForMiscreants(List<String> peoples) {
            boolean found = false;

            for(String people : peoples) {
                if(!found) {
                    if("조커".equals(people)) {
                        System.out.println("people = " + people);
                        found = true;
                    }
                }
            }
        }
    }

    static class New {
        public void checkForMiscreants(List<String> peoples) {
            for(String people : peoples) {
                if("조커".equals(people)) {
                    System.out.println("people = " + people);
                    break; // or return;
                }
            }
        }
    }
}
