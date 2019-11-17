package com.banhe.system.crawler;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitSample {

    public static void main(String[] args) {


        CharSequence inputStr = "abcabytytcab283c";
        String patternStr = "[1-9]";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(inputStr);
        if(matcher.find()){

            System.out.println(matcher.start());//this will give you index
        }


        System.out.println(inputStr.toString().substring(matcher.start()));
//
//        String txt = "펫케어 아르간 오일 바디미스트 237ml";
//        String regex = "^[0-9]*$";
//
//        System.out.println(txt.indexOf(regex));


//        txt.chars().forEach(x-> System.out.println((char)x));


//        //                        boolean c = Pattern.matches("^[0-9]*$", "비교문자");
//
//        String regex = "^[0-9]*$";
//
////        System.out.println(txt.indexOf(regex));
//
//      String[] arrayTxt =  txt.split(regex);
//
//
//        System.out.println(arrayTxt.length);
//        System.out.println(arrayTxt[0]);
//
//        StringBuilder sb = new StringBuilder();
//
//
//
//        Pattern pattern = Pattern.compile(regex);
//
//        Matcher matcher = pattern.matcher(txt);
//
//
//
//
//        boolean found = false;
//
//        while(matcher.find()) {
//
//            System.out.println(matcher.start());
//
//            sb.append("텍스트 \"")
//
//                    .append(matcher.group())      // 찾은 문자열 그룹 입니다.
//
//                    .append("\"를 찾았습니다.\n")
//
//                    .append("인덱스 ")
//
//                    .append(matcher.start())      // 찾은 문자열의 시작 위치 입니다.
//
//                    .append("에서 시작하고, ")
//
//                    .append(matcher.end())        // 찾은 문자열의 끝 위치 입니다.
//
//                    .append("에서 끝납니다.\n");
//
//            found = true;
//
//        }
//
//        if(!found) {
//
//            sb.append("찾지 못했습니다.");
//
//        }
//
//        System.out.println(sb.toString());
//




    }
}
