package com.rtst.dhjc.util;

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
}
