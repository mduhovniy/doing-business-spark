package info.duhovniy.doingbusiness.utils;


import java.util.Arrays;
import java.util.List;

public class WordUtils {

    public static List<String> mSplit(String  list) {
        return Arrays.asList(list.split(" +"));
    }
}
