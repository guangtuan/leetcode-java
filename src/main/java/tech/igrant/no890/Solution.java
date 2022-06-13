package tech.igrant.no890;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Solution {

    private List<Integer> toPattern(String s) {
        Map<Character, Integer> lookup = new HashMap<>();
        List<Integer> standard = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            standard.add(lookup.computeIfAbsent(s.charAt(i), absent -> lookup.size()));
        }
        return standard;
    }

    private Predicate<String> valid(List<Integer> standard) {
        return input -> {
            Map<Character, Integer> lookup = new HashMap<>();
            for (int i = 0; i < input.length(); i++) {
                Integer curr = lookup.computeIfAbsent(input.charAt(i), absent -> lookup.size());
                if (!standard.get(i).equals(curr)) {
                    return false;
                }
            }
            return true;
        };
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<Integer> standard = this.toPattern(pattern);
        return Arrays.stream(words).filter(this.valid(standard)).collect(Collectors.toList());
    }

}
