package tech.igrant.weekly_contest.no308.no2;

import java.util.Stack;

class Solution {

    public String removeStars(String s) {
        char star = "*".charAt(0);
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == star) {
                stack.pop();
            } else {
                stack.add(s.charAt(i));
            }
        }
        StringBuilder ret = new StringBuilder();
        for (Character c : stack) {
            ret.append(c);
        }
        return ret.toString();
    }

}
