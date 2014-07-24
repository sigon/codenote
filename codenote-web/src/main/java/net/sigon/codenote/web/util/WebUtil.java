package net.sigon.codenote.web.util;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 石光 部门：移动研发部-掌上京东
 *         Date: 14-7-18
 *         Time: 上午11:35
 *         To change this template use File | Settings | File Templates.
 * @copyright Copyright 2014-XXXX JD.COM All Right Reserved
 */
public class WebUtil {
    public static Map getMap(HttpServletRequest request) {
        Map bm = new HashMap();
        Map<String, String[]> tmp = request.getParameterMap();
        if (tmp != null) {
            for (String key : tmp.keySet()) {
                String[] values = tmp.get(key);
                bm.put(key, values.length == 1 ? values[0].trim() : values);
            }
        }
        return bm;
    }
}
