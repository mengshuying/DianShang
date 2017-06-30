package com.example.administrator.dianshang.model.utils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * date:${DATA}
 * author:孟淑英
 * function:
 */
public class TextUtil{
    //判断邮箱的正则表达式
    public static boolean isEmailAddress(String url){
        String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(url);
        return matcher.matches();
    }
}
