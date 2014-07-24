package net.sigon.codenote.service.execute.base;

import net.sigon.codenote.common.util.MessageUtil;
import net.sigon.codenote.domain.message.resp.BaseMessage;
import net.sigon.codenote.domain.message.resp.TextMessage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Sguang
 * Date: 14-7-18
 * Time: 下午8:29
 * To change this template use File | Settings | File Templates.
 */
public abstract class TextExecute extends BaseExecute {

    private static Map<String, Class> classMap;
    static {
        classMap = new HashMap<String, Class>();
        classMap.put("xml", TextMessage.class);
    }
    @Override
    public void execute(BaseMessage message, String param, Map<String, String> map) throws Exception {
        message.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
        TextMessage textMessage = (TextMessage) message;
        String content = getContent(param, map);
        if(content!= null && content.length() > 2048){
            content = content.substring(0, 2047);
        }
        textMessage.setContent(content);
    }
    public abstract String getContent(String param, Map<String, String> map);
    public BaseMessage messageFactory(){
        return new TextMessage();
    }

    public Map<String,Class> getClassMap(){
        return classMap;
    }

}
