package tech.igrant.no890;

import java.util.*;
import java.util.stream.Collectors;

class Solution {

    private String toPattern(String s) {
        Map<Character, Integer> lookup = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(lookup.computeIfAbsent(s.charAt(i), absent -> lookup.size()));
        }
        return sb.toString();
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        Map<String, List<String>> patterns = Arrays.stream(words).collect(Collectors.groupingBy(
                this::toPattern
        ));
        return patterns.getOrDefault(this.toPattern(pattern), Collections.emptyList());
    }

}
