package com.blog.utils;/*
 * Copyright 2017 - 数多科技
 *
 * 北京数多信息科技有限公司 本公司保留所有下述内容的权利。
 * 本内容为保密信息，仅限本公司内部使用。
 * 非经本公司书面许可，任何人不得外泄或用于其他目的。
 */


/**
 * @author liuxiujiang
 * @version 1.0
 * @datetime 2019/7/16
 * @since 1.8
 */
public class SystemUtils {
    static {
        if(isLinux()){
            SYSTEM_UPLOAD_PATH = "/data/test/";
        }else{
            SYSTEM_UPLOAD_PATH = "C:\\company\\data\\test\\";
        }
    }
    private static String SYSTEM_UPLOAD_PATH = "C:\\company\\data\\test\\";

    private static boolean isLinux() {
        return System.getProperty("os.name").toLowerCase().indexOf("linux") >= 0;
    }

    public static String getSystemUploadPath(){
        return SYSTEM_UPLOAD_PATH;
    }

    public static void main(String[] args) {
        System.out.println(isLinux());
    }
}
