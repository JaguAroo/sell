package com.imooc.utils;

import java.util.Random;

/**
 * @ClassName: KeyUtil
 * @Description:
 * @Author: 壁垒
 * @Date: 2020/12/10/17:43
 */
public class KeyUtil {
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(90000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
