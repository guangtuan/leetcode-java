package tech.igrant.no899;

import java.util.*;

class Solution {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            StringBuilder sb = new StringBuilder(s);
            for (int i = 1; i < s.length(); i++) {
                sb.append(sb.charAt(0)).deleteCharAt(0);
                if (sb.toString().compareTo(s) < 0) {
                    s = sb.toString();
                }
            }
            return s;
        } else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }

}
