package com.banhe.system.crawler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OptionSplit {

    public static String getOption(String title){
        CharSequence inputStr = title;
        String patternStr = "[1-9]";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(inputStr);
        if(matcher.find()){
            return inputStr.toString().substring(matcher.start());
        } else {
            return "";
        }
    }
}
