package com.util;

import java.security.MessageDigest;

/**
 * MD5工具类
 *
 * @author chenys
 */
public class md5util {

    /**
     * 获取MD5
     *
     * @param input 字符串
     * @return
     */
    public static String getMd5(String input) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(input.getBytes());
            return toHexStringXiao(md5.digest());  //取决大写16进制还是小写16进制
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 获取MD5
     *
     * @param input 字符串
     * @param encode 编码
     * @return
     */
    public static String getMd5(String input, String encode) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(input.getBytes(encode));
            return toHexStringXiao(md5.digest());
        } catch (Exception e) {
            return "";
        }
    }

    //小写16进制
    private static char[] hexCharXiao = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };

    //大写16进制
    private static char[] hexChar = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };


    /**
     * byte数组转成十六进制小写字符串
     *
     * @param b
     * @return
     * @throws Exception
     */
    public static String toHexStringXiao(byte[] b) throws Exception {
        StringBuilder sb = new StringBuilder(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            sb.append(hexCharXiao[(b[i] & 0xf0) >>> 4]);
            sb.append(hexCharXiao[b[i] & 0x0f]);
        }
        return sb.toString();
    }

    /**
     * byte数组转成十六进制大写字符串
     *
     * @param bytetest：需要转换的byte数组
     * @return
     * @throws Exception
     */
    public static String toHexString(byte[] bytetest) throws Exception {
        StringBuilder sb = new StringBuilder(bytetest.length * 2);
        for (int i = 0; i < bytetest.length; i++) {
            sb.append(hexChar[(bytetest[i] & 0xf0) >>> 4]);
            sb.append(hexChar[bytetest[i] & 0x0f]);
        }
        return sb.toString();
    }



    private static final String HEX_NUMS_STR = "0123456789ABCDEF";

    /**
     * 将16进制字符串转换成字节数组
     *
     * @param hex：需要转换的字符串
     * @return
     */
    public static byte[] hexStringToByte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] hexChars = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (HEX_NUMS_STR.indexOf(hexChars[pos]) << 4 | HEX_NUMS_STR
                    .indexOf(hexChars[pos + 1]));
        }
        return result;
    }

}
