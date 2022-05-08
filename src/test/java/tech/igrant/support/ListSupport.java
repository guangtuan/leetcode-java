package tech.igrant.support;

import java.util.List;
import java.util.stream.Collectors;

public class ListSupport {

    public static <T> String hash(List<T> any) {
        return any.stream().map(Object::toString).collect(Collectors.joining(","));
    }

}
