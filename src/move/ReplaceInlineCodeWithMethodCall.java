package move;

import java.util.Arrays;

/**
 * Replace Inline Code With Method Call
 *
 * 인라인 코드를 메서드 호출로 바꾸기
 */
public class ReplaceInlineCodeWithMethodCall {

    static class Old {
        public boolean appliesToMess(String[] states) {
            boolean result = false;

            for(String state : states) {
                if("NA".equals(state)) {
                    result = true;
                }
            }

            return result;
        }
    }

    static class New {
        public boolean appliesToMess(String[] states) {
            return Arrays.asList(states)
                    .contains("NA");
        }
    }
}
