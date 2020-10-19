package com.xxxx.util;

public class StringUtil {
    public static boolean isEmpty(String str){
        if (str == null || "".equals(str.trim())){
            return true;
        }
        else{
            return false;
        }
    }

    // Split JSON Array string to JSON strings.
    public static String[] SplitStrings(String s) {
        String[] ss = s.substring(1,s.length()-1).split("},\\{"); // Get rid of "[]" in "[{},{}]", and split deals

        if (ss.length == 1) {
            return ss;
        }
        for (int i = 0; i < ss.length; i++){ // Reconstruct string format to json format
            if (i == 0) {
                ss[i] += "}";
            }else if (i == ss.length-1){
                ss[i] = "{" + ss[i];
            }else {
                ss[i] = "{" + ss[i] + "}";
            };
        }
        return ss;
    }
}
