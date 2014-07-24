package net.sigon.codenote.domain.util;

import java.util.Random;

/**
 * @author 石光 部门：移动研发部-掌上京东
 *         Date: 14-4-5
 *         Time: 下午5:02
 *         To change this template use File | Settings | File Templates.
 * @copyright Copyright 2014-XXXX JD.COM All Right Reserved
 */
public class RandomUtil {
    private static String numberString = "0123456789";//随机产生的字符串
    private static String randString = "0123456789ABCDEFGHIJKLMNOPQOSTUVWXYZ";//随机产生的字符串
    private static Random random = new Random();

    public static String generateNumbers(Integer c){
        StringBuilder builder = new StringBuilder();
        for(int i = 0 ; i < c ; i ++){
            builder.append(generateChar(numberString));
        }
        return builder.toString();
    }
    public static String generateCode(Integer c){
        StringBuilder builder = new StringBuilder();
        for(int i = 0 ; i < c ; i ++){
            builder.append(generateChar(randString));
        }
        return builder.toString();
    }
    public static String generateChar(String str){
        String rand = String.valueOf(str.charAt((random.nextInt(str.length()))));
        return rand;
    }
}
