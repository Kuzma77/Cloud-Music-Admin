package com.soft1851.music.admin.util;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.util.Random;
import java.util.UUID;

/**
 * @author wl_sun
 * @description TODO
 * @create Date
 */
public class Salt {

    /**
     * 随机生成一个字符串
     *
     * @return
     */
    public static String getRandomSalt() {
        String model = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuffer salt = new StringBuffer();
        char[] m = model.toCharArray();
        for (int i = 0; i < 32; i++) {
            char c = m[(int) (Math.random() * 36)];
            salt = salt.append(c);
        }
        return salt.toString();
    }

    /**
     *
     * 加密
     * @param password
     * @param salt
     * @return
     */
    public static String generate(String password, String salt) {
        password = md5Hex(password + salt);
        char[] cs = new char[32];
        for (int i = 0; i < 32; i += 3) {
            cs[i] = password.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        return new String(cs);
    }
    public static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new Hex().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        String password = "admin";
        String salt = Salt.getRandomSalt();
        String NewPassword = Salt.generate(password,salt);
        System.out.println(NewPassword);
    }
}
