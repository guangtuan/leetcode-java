package tech.igrant.no46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    public List<List<Integer>> permute(int[] nums) {
        return generate(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }

    List<List<Integer>> generate(List<Integer> array) {
        if (array.size() == 1) {
            return Collections.singletonList(array);
        }
        final int[] holder = new int[]{0};
        return array.stream().
                map(curr -> generate(remove(holder[0]++, array))
                        .stream()
                        .map(ret -> merge(ret, curr))
                        .collect(Collectors.toList())
                )
                .reduce(
                        new ArrayList<>(),
                        (acc, curr) -> {
                            acc.addAll(curr);
                            return acc;
                        }
                );
    }

    private List<Integer> merge(List<Integer> ret, Integer integer) {
        ret.add(integer);
        return ret;
    }

    List<Integer> remove(int index, List<Integer> origin) {
        List<Integer> ret = new ArrayList<>(origin);
        ret.remove(index);
        return ret;
    }

}
