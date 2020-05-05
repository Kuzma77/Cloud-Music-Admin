package com.soft1851.music.admin.util;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Iterator;

/**
 * @author wl_sun
 * @description TODO
 * @Data 2020/5/3
 */



public class PhoneCodeUtil {

    private static final String SYMBOLS = "0123456789"; // 数字

    // 字符串
    // private static final String SYMBOLS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final Random RANDOM = new SecureRandom();

    public static void main(String[] args) {
        System.out.println(getVerifyCode());
    }

    /**
     * 获取长度为 6 的随机数字
     * @return 随机数字
     * @date 修改日志：由 space 创建于 2018-8-2 下午2:43:51
     */
    public static String getVerifyCode() {

        // 如果需要4位，那 new char[4] 即可，其他位数同理可得
        char[] nonceChars = new char[6];

        for (int index = 0; index < nonceChars.length; ++index) {
            nonceChars[index] = SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length()));
        }

        return new String(nonceChars);
    }


}