package tech.igrant.support;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HashSupport {

    public static <T> Function<List<T>, String> express(
            Function<T, String> hash
    ) {
        return arr -> arr.stream().map(hash).collect(Collectors.joining(","));
    }

}
