package tech.igrant.no890;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

class Solution {

    Predicate<String> same(String pattern) {
        return word -> {
            Map<Character, Character> fn1 = new HashMap<>();
            Map<Character, Character> fn2 = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                char input = pattern.charAt(i);
                char output = word.charAt(i);
                if (fn1.containsKey(input)) {
                    if (output != fn1.get(input)) {
                        return false;
                    }
                } else {
                    fn1.put(input, output);
                }
                if (fn2.containsKey(output)) {
                    if (input != fn2.get(output)) {
                        return false;
                    }
                } else {
                    fn2.put(output, input);
                }
            }
            return true;
        };
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        return Arrays.stream(words).filter(same(pattern)).toList();
    }

}
