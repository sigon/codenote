package net.sigon.codenote.domain.util;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 石光 部门：移动研发部-掌上京东
 *         Date: 14-4-10
 *         Time: 下午3:07
 *         To change this template use File | Settings | File Templates.
 * @copyright Copyright 2014-XXXX JD.COM All Right Reserved
 */
public class ReflectUtil {

    public static Map objectToMap(Object obj) throws Exception{
        Class clazz = obj.getClass();
        Field[] fields = clazz.getFields();
        Map map = new HashMap();
        for(Field f : fields){
            f.setAccessible(true);
            Object value = null;
            Object val = f.get(obj);
            if(f.getType().equals(Date.class)){
                value = DateUtil.date2String((Date)val);
            }else if(val != null){
                value = val.toString();
            }
            if(value != null){
                map.put(f.getName(), value);
            }
        }
        return map;
    }
}
