package edu.eci.aygo.prototipo.common.utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class YmlUtils {
    public static String indentLines(String s) {
        return Arrays.stream(s.split("\\R"))
                .map(line -> "  " + line) // use spaces, not tabs
                .collect(Collectors.joining("\n"));
    }
}
