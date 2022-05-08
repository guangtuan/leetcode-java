package tech.igrant.no448;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> target = IntStream.rangeClosed(1, nums.length).boxed().collect(Collectors.toSet());
        for (int num : nums) {
            target.remove(num);
        }
        return new ArrayList<>(target);
    }
}
