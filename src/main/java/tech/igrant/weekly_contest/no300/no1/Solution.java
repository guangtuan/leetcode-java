package tech.igrant.weekly_contest.no300.no1;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public String decodeMessage(String key, String message) {
        Map<String, String> mapping = new HashMap<>();
        int[] holder = new int[] {0};
        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) == ' ') {
                continue;
            }
            String c = Character.toString(key.charAt(i));
            if (!mapping.containsKey(c)) {
                mapping.put(c, Character.toString('a' + holder[0] ++));
            }
        }
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == ' ') {
                ret.append(" ");
                continue;
            }
            ret.append(mapping.get(Character.toString(message.charAt(i))));
        }
        return ret.toString();
    }

}
