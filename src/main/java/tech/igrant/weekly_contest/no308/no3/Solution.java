package tech.igrant.weekly_contest.no308.no3;

class Solution {

    public int garbageCollection(String[] garbage, int[] travel) {
        // travel 求一把前缀和
        // 遍历一把 garbage，找出最晚的三种垃圾出现的房子数
        int[] totalTravel = new int[garbage.length];
        totalTravel[0] = 0;
        for (int i = 1; i < garbage.length; i++) {
            totalTravel[i] = totalTravel[i - 1] + travel[i - 1];
        }
        int lastM = 0;
        int lastG = 0;
        int lastP = 0;
        int costOfM = 0;
        int costOfG = 0;
        int costOfP = 0;
        for (int i = 0; i < garbage.length; i++) {
            String currentHouse = garbage[i];
            for (int j = 0; j < currentHouse.length(); j++) {
                char c = currentHouse.charAt(j);
                switch (c) {
                    case 'M' -> {
                        costOfM++;
                        lastM = i;
                    }
                    case 'G' -> {
                        costOfG++;
                        lastG = i;
                    }
                    case 'P' -> {
                        costOfP++;
                        lastP = i;
                    }
                    default -> {
                    }
                }
            }
        }
        return costOfM + costOfG + costOfP +
                totalTravel[lastG] + totalTravel[lastM] + totalTravel[lastP];
    }

}