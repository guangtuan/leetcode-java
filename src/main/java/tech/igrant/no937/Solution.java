package tech.igrant.no937;

import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        return Arrays
                .stream(logs)
                .map(Inner::fromString)
                .sorted((t1, t2) -> {
                    if (t1.isNumber && t2.isNumber) {
                        return 0;
                    }
                    if (t1.isNumber) {
                        return 1;
                    }
                    if (t2.isNumber) {
                        return -1;
                    }
                    int result = t1.getValuesJoint().compareTo(t2.getValuesJoint());
                    if (result == 0) {
                        return t1.flag().compareTo(t2.flag());
                    } else {
                        return result;
                    }
                })
                .map(i -> i.origin)
                .collect(Collectors.toList())
                .toArray(new String[]{});
    }

    private static class Inner {
        private String[] values;

        private boolean isNumber;

        private String valuesJoint;

        private String origin;

        static Inner fromString(String origin) {
            Inner inner = new Inner();
            inner.values = origin.split(" ", 2);
            inner.isNumber = Character.isDigit(inner.values[1].charAt(0));
            inner.origin = origin;
            return inner;
        }

        String flag() {
            return this.values[0];
        }

        String getValuesJoint() {
            return this.values[1];
        }

    }

}