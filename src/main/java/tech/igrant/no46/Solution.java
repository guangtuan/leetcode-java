package tech.igrant.no46;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {

    public List<List<Integer>> permute(int[] array) {
        if (array.length == 1) {
            return onlyOne(onlyOne(array[0]));
        }
        return IntStream.range(0, array.length)
                .mapToObj(index -> permute(remove(index, array))
                        .stream()
                        .map(ret -> merge(ret, array[index]))
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

    private <T> List<T> onlyOne(T ele) {
        List<T> ret = new ArrayList<>();
        ret.add(ele);
        return ret;
    }

    private List<Integer> merge(List<Integer> ret, Integer integer) {
        ret.add(integer);
        return ret;
    }

    int[] remove(int index, int[] array) {
        int[] ret = new int[array.length - 1];
        System.arraycopy(array, 0, ret, 0, index);
        System.arraycopy(array, index + 1, ret, index, ret.length - index);
        return ret;
    }

}
