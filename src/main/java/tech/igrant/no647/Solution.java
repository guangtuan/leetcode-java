package tech.igrant.no647;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {

    String removeHeadAndTail(String str) {
        return str.substring(1, str.length() - 1);
    }

    public int countSubstrings(String s) {
        Map<String, Integer> answer = Arrays.stream(s.split("")).collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.summingInt(value -> 1)
        ));
        for (int lengthToCheck = 2; lengthToCheck <= s.length(); lengthToCheck++) {
            for (int i = 0; i <= s.length() - lengthToCheck; i++) {
                String currentCheck = s.substring(i, i + lengthToCheck);
                if (answer.containsKey(currentCheck)) {
                    answer.put(currentCheck, answer.get(currentCheck) + 1);
                } else {
                    if (currentCheck.charAt(0) == currentCheck.charAt(currentCheck.length() - 1)) {
                        String prev = removeHeadAndTail(currentCheck);
                        if (prev.length() == 0 || answer.containsKey(prev)) {
                            answer.put(currentCheck, 1);
                        }
                    }
                }
            }
        }
        return answer.values().stream().reduce(0, Integer::sum);
    }

}
