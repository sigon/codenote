package net.sigon.codenote.domain.util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 石光 部门：移动研发部-掌上京东
 *         Date: 14-4-10
 *         Time: 下午1:38
 *         To change this template use File | Settings | File Templates.
 * @copyright Copyright 2014-XXXX JD.COM All Right Reserved
 */
public class BeanUtil {
    public List<Object> copyList(List<Object> list, Class clazz) throws Exception{
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        List<Object> rlist = new ArrayList<Object>();
        for(Object item:list){
            Object o = clazz.newInstance();
            BeanUtils.copyProperties(o, item);
            rlist.add(o);
        }
        return rlist;
    }
}
