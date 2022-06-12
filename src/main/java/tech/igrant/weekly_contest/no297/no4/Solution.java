package tech.igrant.weekly_contest.no297.no4;

import java.util.*;
import java.util.stream.Collectors;

class Solution {

    private static class Each {

        private final String head;
        private final String suffix;

        public Each(String origin) {
            this.head = String.valueOf(origin.charAt(0));
            this.suffix = origin.substring(1);
        }

        public String getHead() {
            return head;
        }

        public String getSuffix() {
            return suffix;
        }
    }


    public long distinctNames(String[] ideas) {
        Map<String, Set<String>> groupByHead = Arrays.stream(ideas)
                .map(Each::new)
                .collect(Collectors.groupingBy(
                        Each::getHead,
                        Collectors.mapping(Each::getSuffix, Collectors.toSet())
                ));
        List<Map.Entry<String, Set<String>>> es = new ArrayList<>(groupByHead.entrySet());
        long ret = 0;
        for (int i = 0; i < es.size(); i++) {
            for (int j = i + 1; j < es.size(); j++) {
                Map.Entry<String, Set<String>> e1 = es.get(i);
                Map.Entry<String, Set<String>> e2 = es.get(j);
                long diff = diff(e1.getValue(), e2.getValue());
                ret += diff * 2;
            }
        }
        return ret;
    }

    private long diff(Set<String> v1, Set<String> v2) {
        Set<String> cp1 = new HashSet<>(v1);
        Set<String> cp2 = new HashSet<>(v2);
        cp1.removeAll(v2);
        cp2.removeAll(v1);
        return (long) cp1.size() * cp2.size();
    }

}
