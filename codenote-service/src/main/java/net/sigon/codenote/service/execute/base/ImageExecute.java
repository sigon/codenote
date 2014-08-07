package net.sigon.codenote.service.execute.base;

import net.sigon.codenote.common.util.MessageUtil;
import net.sigon.codenote.domain.message.resp.BaseMessage;
import net.sigon.codenote.domain.message.resp.Image;
import net.sigon.codenote.domain.message.resp.ImageMessage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Sguang
 * Date: 14-7-18
 * Time: 下午8:29
 * To change this template use File | Settings | File Templates.
 */
public abstract class ImageExecute extends BaseExecute {

    private static Map<String, Class> classMap;
    static {
        classMap = new HashMap<String, Class>();
        classMap.put("xml", ImageMessage.class);
        classMap.put("Image", Image.class);
    }
    @Override
    public void execute(BaseMessage message, String param, Map<String, String> map) throws Exception {
        message.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_IMAGE);
        ImageMessage imageMessage = (ImageMessage)message;
        Image image = new Image();
        image.setMediaId(getMediaId(param, map));
        imageMessage.setImage(image);
    }
    public abstract String getMediaId(String param, Map<String, String> map);
    public BaseMessage messageFactory(){
        return new ImageMessage();
    }

    public Map<String,Class> getClassMap(){
        return classMap;
    }

}
