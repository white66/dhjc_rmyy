package com.rtst.dhjc.util;

import java.math.BigInteger;

/**
 * @Author white Liu
 * @Date 2019/12/20 11:11
 * @Version 1.0
 */
public class StringUtil {
    /**
     * 十进制正负数转二进制字符串
     * @param number
     * @return
     */
    public static String tenTurnTwo(int number) {
        StringBuffer sb = new StringBuffer();
        if (number > 0) {
            while (number != 0) {
                if (number > 0) {
                    sb.insert(0,number % 2);
                    number = number / 2;
                }
            }
        } else if (number < 0) {
            for (int i = 0; i < 8; i++) {
                // 0x80000000 是一个首位为1，其余位数为0的整数
                int t = (number & 0x80000000 >>> i) >>> (31 - i);
                sb.append(t);
            }
        } else if(number==0){
            sb.append("00000000");
        }
        while(sb.length()<8){
            sb.reverse();
            sb.append("0");
            sb.reverse();
        }
        return sb.toString();
    }
    /**
     * 字节数组转成16进制表示格式的字符串
     *
     * @param byteArray
     *            需要转换的字节数组
     * @return 16进制表示格式的字符串
     **/
    public static String toHexString(byte[] byteArray) {
        if (byteArray == null || byteArray.length < 1)
            throw new IllegalArgumentException("this byteArray must not be null or empty");

        final StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < byteArray.length; i++) {
            if ((byteArray[i] & 0xff) < 0x10)//0~F前面不零
                hexString.append("0");
            hexString.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        return hexString.toString().toLowerCase();
    }
    public static int fuTurnzheng(int number){
        int resultNum=0;
        if(number>=0){
            resultNum = number;
        }else if(number<0){
            resultNum= 256+number;
        }
        return resultNum;
    }
    /**
     * 16进制字符串转有符号float类型数
     * @param hexString  C023D70A
     * @return
     */
    public static float toFloat(String hexString){
        BigInteger b = new BigInteger(hexString,16);
        float resultValue = Float.intBitsToFloat(b.intValue());
        return resultValue;
    }
    /**
     * 16进制字符串转无符号float
     * @param hexString  40051269
     * @return
     */
    public static float toFloatNoSign(String hexString){
        float resultValue = Float.intBitsToFloat(Integer.valueOf(hexString, 16));
        return resultValue;
    }
}
