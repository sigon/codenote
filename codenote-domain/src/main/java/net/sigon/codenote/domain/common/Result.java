package net.sigon.codenote.domain.common;

import net.sigon.codenote.domain.json.base.BaseResult;
import org.springframework.ui.ModelMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 石光 部门：移动研发部-掌上京东
 *         Date: 14-4-2
 *         Time: 上午10:38
 *         To change this template use File | Settings | File Templates.
 * @copyright Copyright 2014-XXXX JD.COM All Right Reserved
 */
public class Result extends BaseResult {
    private boolean success = true;
    private Map<String, Object> map = new HashMap<String, Object>();

    public Object addAttribute(String key, Object value){
        return map.put(key, value);
    }
    public void convertModelMap(ModelMap modelMap){
        for(String key:map.keySet()){
            modelMap.put(key, map.get(key));
        }
    }
    public Object get(String key){
        return map.get(key);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
