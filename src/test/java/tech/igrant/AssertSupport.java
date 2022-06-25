package tech.igrant;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AssertSupport {

    public static <T> boolean listEquals(Function<T, String> hash, List<T> l1, List<T> l2) {
        Set<String> h1 = l1.stream().map(hash).collect(Collectors.toSet());
        Set<String> h2 = l2.stream().map(hash).collect(Collectors.toSet());
        System.out.println(h1);
        System.out.println(h2);
        return h1.containsAll(h2) && h2.containsAll(h1);
    }

}
