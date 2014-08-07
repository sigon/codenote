package net.sigon.codenote.common.util;

import net.sigon.codenote.domain.tree.Tree;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
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
        map = parseTreeXml();
    }
    private static Map<String, Tree> parseTreeXml(){
        try {
            File treeXmlFile = new ClassPathResource(TREE_XML_PATH).getFile();

            // 读取输入流
            SAXReader reader = new SAXReader();
            Document document = reader.read(treeXmlFile);
            // 得到xml根元素
            Element root = document.getRootElement();
            // 得到根元素的所有子节点
            Element ele = (Element)root.elements().get(0);
            Map<String, Tree> map = new HashMap<String, Tree>();
            map.put("main", parseElement(ele));
            return map;
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (DocumentException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return map;
    }

    private static Tree parseElement(Element ele) {
        Tree tree = new Tree();
        tree.setType(ele.attributeValue("type"));
        tree.setExec(ele.attributeValue("exec"));
        tree.setKey(ele.attributeValue("key"));
        tree.setParam(ele.attributeValue("param"));
        if(StringUtils.isNotBlank(tree.getType())){
            Map<String, Tree> map = new HashMap<String, Tree>();
            for(Object o:ele.elements()){
                Element e = (Element)o ;
                map.put(e.attributeValue("key"), parseElement(e));
            }
            tree.setMap(map);
        }
        return tree;
    }
    public static Tree exec(Map<String, String> param){
        String type = map.get("main").getType();
        return findTree(type, param, map.get("main").getMap());
    }

    private static Tree findTree(String type, Map<String, String> param, Map<String, Tree> treeMap) {
        String key = param.get(type).trim();
        Tree tree = treeMap.get(key);
        if(tree == null){
            tree = new Tree();
            tree.setExec("defaultExecute");
            return tree;
        }
        if(StringUtils.isBlank(tree.getType())){
            return tree;
        }else{
            return findTree(tree.getType(), param, tree.getMap());
        }
    }
}
