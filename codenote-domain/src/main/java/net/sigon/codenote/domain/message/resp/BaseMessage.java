package net.sigon.codenote.domain.message.resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author 石光 部门：移动研发部-掌上京东
 *         Date: 14-7-18
 *         Time: 下午3:36
 *         To change this template use File | Settings | File Templates.
 * @copyright Copyright 2014-XXXX JD.COM All Right Reserved
 */

@XmlAccessorType(value = XmlAccessType.FIELD)
public class BaseMessage {
    // 接收方帐号（收到的OpenID）
    private String ToUserName;
    // 开发者微信号
    private String FromUserName;
    // 消息创建时间 （整型）
    private long CreateTime;
    // 消息类型（text/music/news）
    private String MsgType;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }
}
