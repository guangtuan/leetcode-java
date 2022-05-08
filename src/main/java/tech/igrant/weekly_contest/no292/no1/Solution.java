package tech.igrant.weekly_contest.no292.no1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public String largestGoodInteger(String num) {
        Map<Integer, Integer> st = new HashMap<>();
        Set<Integer> keep = new HashSet<>();
        int current = -1;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            int curr = Integer.parseInt(String.valueOf(c));
            if (curr == current) {
                st.computeIfAbsent(curr, number -> 1);
                st.put(curr, st.get(curr) + 1);
                if (st.get(curr) >= 3) {
                    keep.add(curr);
                }
            } else {
                st.clear();
            }
            current = curr;
        }
        return keep.stream()
                .max(Integer::compareTo)
                .map(e -> String.format("%d%d%d", e, e, e))
                .orElse("");
    }
}