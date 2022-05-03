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

    static boolean isNumber(String s) {
        char c = s.charAt(0);
        return "9".charAt(0) >= c && c >= "0".charAt(0);
    }

    private static class Inner {
        private String[] values;

        private boolean isNumber;

        private String valuesJoint;

        private String origin;

        static Inner fromString(String origin) {
            Inner inner = new Inner();
            inner.values = origin.split(" ");
            inner.isNumber = Solution.isNumber(inner.values[1]);
            inner.origin = origin;
            return inner;
        }

        String flag() {
            return this.values[0];
        }

        String getValuesJoint() {
            if (this.valuesJoint == null) {
                StringBuilder builder = new StringBuilder();
                for (int i = 1; i < this.values.length; i++) {
                    builder.append(this.values[i]);
                    builder.append(",");
                }
                this.valuesJoint = builder.toString();
            }
            return this.valuesJoint;
        }

    }

}