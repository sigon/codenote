package net.sigon.codenote.service.core.impl;

import net.sigon.codenote.common.util.TreeUtil;
import net.sigon.codenote.domain.tree.Tree;
import net.sigon.codenote.service.core.CoreService;
import net.sigon.codenote.service.execute.base.BaseExecute;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author 石光 部门：移动研发部-掌上京东
 *         Date: 14-7-18
 *         Time: 下午4:48
 *         To change this template use File | Settings | File Templates.
 * @copyright Copyright 2014-XXXX JD.COM All Right Reserved
 */
@Service("coreServiceImpl")
public class CoreServiceImpl implements CoreService {
    @Resource(name = "executeMap")
    private Map<String, BaseExecute> executeMap;
    /**
     * 处理微信发来的请求
     *
     * @param map
     * @return
     */
    public String processRequest(Map<String, String> map) {
        Tree tree = TreeUtil.exec(map);
        BaseExecute execute = executeMap.get(tree.getExec());
        try {
            return execute.doTrans(tree.getParam(), map);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
//        String respMessage = null;
//        try {
//            // 默认返回的文本消息内容
//            String respContent = "请求处理异常，请稍候尝试！";
//
//            // 发送方帐号（open_id）
//            String fromUserName = requestMap.get("FromUserName");
//            // 公众帐号
//            String toUserName = requestMap.get("ToUserName");
//            // 消息类型
//            String msgType = requestMap.get("MsgType");
//
//            // 回复文本消息
//            TextMessage textMessage = new TextMessage();
//            textMessage.setToUserName(fromUserName);
//            textMessage.setFromUserName(toUserName);
//            textMessage.setCreateTime(new Date().getTime());
//            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
//            textMessage.setFuncFlag(0);
//
//            // 文本消息
//            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
//                respContent = "您发送的是文本消息:" + requestMap.get("Content");
//            }
//            // 图片消息
//            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
//                respContent = "您发送的是图片消息！";
//            }
//            // 地理位置消息
//            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
//                respContent = "您发送的是地理位置消息！";
//            }
//            // 链接消息
//            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
//                respContent = "您发送的是链接消息！";
//            }
//            // 音频消息
//            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
//                respContent = "您发送的是音频消息！";
//            }
//            // 事件推送
//            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
//                // 事件类型
//                String eventType = requestMap.get("Event");
//                // 订阅
//                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
//                    respContent = "谢谢您的关注！";
//                }
//                // 取消订阅
//                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
//                    // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
//                }
//                // 自定义菜单点击事件
//                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
//                    // TODO 自定义菜单权没有开放，暂不处理该类消息
//                }
//            }
//
//            textMessage.setContent(respContent);
//            respMessage = MessageUtil.textMessageToXml(textMessage);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        return respMessage;
    }
}
