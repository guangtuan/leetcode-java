package tech.igrant.weekly_contest.no308.no3;

import java.util.*;

class Solution {

    public int garbageCollection(String[] garbage, int[] travel) {
        // travel 求一把前缀和
        // 遍历一把 garbage，找出最晚的三种垃圾出现的房子数
        int[] totalTravel = new int[garbage.length];
        totalTravel[0] = 0;
        for (int i = 1; i < garbage.length; i++) {
            totalTravel[i] = totalTravel[i - 1] + travel[i - 1];
        }
        Map<String, Integer> last = new HashMap<>();
        int cost = 0;
        Set<String> types = new HashSet<>(Arrays.asList("M", "P", "G"));
        for (int j = garbage.length - 1; j >= 0; j--) {
            String currentHouse = garbage[j];
            cost += currentHouse.length();
            if (!types.isEmpty()) {
                for (String type : types) {
                    if (currentHouse.contains(type)) {
                        last.put(type, totalTravel[j]);
                    }
                }
                types.removeAll(last.keySet());
            }
        }
        return cost + last.values().stream().reduce(0, Integer::sum);
    }

}