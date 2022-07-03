package tech.igrant.weekly_contest.no300.no1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

class Solution {

    public String decodeMessage(String key, String message) {
        Map<String, String> mapping = Arrays.stream(key.split(""))
                .filter(c -> !Objects.equals(" ", c))
                .reduce(
                        new HashMap<>(),
                        (acc, s) -> {
                            acc.computeIfAbsent(s, absent -> Character.toString('a' + acc.size()));
                            return acc;
                        },
                        (m1, m2) -> m2
                );
        return Arrays.stream(message.split(""))
                .map(k -> mapping.getOrDefault(k, " "))
                .collect(Collectors.joining(""));
    }

}
