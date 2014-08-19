package net.sigon.codenote.common.util;

import net.sigon.codenote.domain.constant.WeixinConstant;
import net.sigon.codenote.domain.tree.Tree;
import net.sigon.codenote.domain.tree.UserMember;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 石光 部门：移动研发部-掌上京东
 *         Date: 14-7-18
 *         Time: 下午6:08
 *         To change this template use File | Settings | File Templates.
 * @copyright Copyright 2014-XXXX JD.COM All Right Reserved
 */
public class TreeUtil {
    private static final String TREE_XML_PATH = "tree.xml";
    private static Map<String, Tree> map;
    static {
        init();
    }
    private static void init(){
        try {
            File treeXmlFile = new ClassPathResource(TREE_XML_PATH).getFile();

            // 读取输入流
            SAXReader reader = new SAXReader();
            Document document = reader.read(treeXmlFile);
            // 得到xml根元素
            Element root = document.getRootElement();
            // 得到根元素的所有子节点
            Element ele = root.element("main");
            map = new HashMap<String, Tree>();
            map.put("main", parseElement(ele));
            map.put("default", parseElement(root.element("default")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Tree parseElement(Element ele) {
        Tree tree = new Tree();
        tree.setType(ele.attributeValue("type"));
        tree.setExec(ele.attributeValue("exec"));
        tree.setKey(ele.attributeValue("key"));
        tree.setParam(ele.attributeValue("param"));

        List list = ele.elements();

        if(CollectionUtils.isEmpty(list)){
            return tree;
        }
        Map<String, Tree> map = new HashMap<String, Tree>();
        for(Object o:list){
            Element e = (Element)o ;
            map.put(e.attributeValue("key"), parseElement(e));
        }

        tree.setMap(map);
        return tree;
    }
    public static Tree exec(Map<String, String> param){
        String type = param.get(WeixinConstant.MsgType);
        String userName = param.get(WeixinConstant.FromUserName);
        String content = null;
        if(type.equals("text")){
            content = param.get(WeixinConstant.Content);
        }
        //返回首页
        if("0".equals(content)){
            UserMemberUtil.deleteUserMember(userName);
        }

        UserMember userMember = UserMemberUtil.getMember(userName);
        if(userMember == null){
            userMember = UserMemberUtil.createUserMember(userName, map.get("main"));
        }
        //Map<String, Tree> treeMap = map.get("main").getMap();

        Tree tree = findTree(content, param, userMember.getTree());
        if(tree.getMap() != null){
            userMember.setTree(tree);
        }

        return tree;
    }

    private static Tree findTree(String key, Map<String, String> param, Tree head) {
        Map<String, Tree> treeMap = head.getMap();
        Tree tree = treeMap.get(key);
        if(treeMap == null || tree == null){
            if(head.getExec() != null){
                return head;
            }
            return map.get("default").getMap().get(param.get(WeixinConstant.MsgType));
        }
        return tree;
//        if(treeMap == null){
//            tree = head;
//            if(tree.getExec() != null){
//                return tree;
//            }
//            tree = map.get("default").getMap().get(param.get(WeixinConstant.MsgType));
//            //tree.setExec("defaultExecute");
//            return tree;
//        }else{
//            tree = treeMap.get(key);
//        }
//        if(StringUtils.isBlank(tree.getType())){
//            return tree;
//        }else{
//            return findTree(tree.getType(), param, tree);
//        }
    }
}
