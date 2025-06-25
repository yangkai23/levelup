package com.streamapi;

import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class M2PTest {
    public static void main(String[] args) {
        var name = "Shanmukha Anirudh";
          name.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum))
                .values()
                .stream().max(Comparator.naturalOrder()).orElse(-1L);


    }
}