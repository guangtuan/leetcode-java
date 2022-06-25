package tech.igrant.no46

import java.util.stream.Collectors

class SolutionKt {

    fun permute(array: IntArray): List<List<Int>> {
        return if (array.size == 1) {
            listOf(listOf(array[0]))
        } else {
            array.indices
                    .map { index: Int ->
                        permute(remove(index, array))
                                .stream()
                                .map { ret -> ret + array[index] }
                                .collect(Collectors.toList())
                    }
                    .toList()
                    .flatten()
        }
    }

    private fun remove(index: Int, array: IntArray): IntArray {
        return IntArray(array.size - 1).apply {
            System.arraycopy(array, 0, this, 0, index)
            System.arraycopy(array, index + 1, this, index, this.size - index)
        }
    }

}