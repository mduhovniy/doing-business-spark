package info.duhovniy.doingbusiness.utils;


import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class WordUtils {

    @NotNull
    public static List<String> mSplit(String  list) {
        return Arrays.asList(list.split(" +"));
    }
}
