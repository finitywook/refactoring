package move;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Replace Loop With Pipeline
 *
 * 반복문을 파이프라인으로 바꾸기
 */
public class ReplaceLoopWithPipeline {

    static class Old {
        public List<Branch> acquireData(String input) {
            final String[] lines = input.split("\n");
            boolean firstLine = true;
            final List<Branch> result = new ArrayList<>();

            for(String line : lines) {
                if(firstLine) {
                    firstLine = false;
                    continue;
                }

                if("".equals(line.trim())) {
                    continue;
                }

                final String[] record = line.split(",");

                if("India".equals(record[1].trim())) {
                    result.add(new Branch(record[0].trim(), record[2].trim()));
                }
            }

            return result;
        }
    }

    static class New {
        public List<Branch> acquireData(String input) {
            final String[] lines = input.split("\n");

            return Arrays.stream(lines)
                    .skip(1) // first line
                    .filter(line -> !"".equals(line.trim())) // empty line
                    .map(line -> line.split(",")) // record
                    .filter(record -> "India".equals(record[1].trim()))
                    .map(record -> new Branch(record[0].trim(), record[2].trim()))
                    .collect(Collectors.toList());
        }
    }

    static class Branch {
        String city;
        String phone;

        public Branch(String city, String phone) {
            this.city = city;
            this.phone = phone;
        }
    }
}
