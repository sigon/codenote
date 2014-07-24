package net.sigon.codenote.domain.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 石光 部门：移动研发部-掌上京东
 *         Date: 14-4-10
 *         Time: 下午3:25
 *         To change this template use File | Settings | File Templates.
 * @copyright Copyright 2014-XXXX JD.COM All Right Reserved
 */
public class DateUtil {
    public static String dateFormat = "yyyy-MM-dd hh:mm:ss";
    public static String date2String(Date date){
        return date2String(date, dateFormat);
    }
    public static String date2String(Date date, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Date string2Date(String date) throws Exception{
        return string2Date(date,dateFormat);
    }

    public static Date string2Date(String date,String format) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(date);
    }
}
