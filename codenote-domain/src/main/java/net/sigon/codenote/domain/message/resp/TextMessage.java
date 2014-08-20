package net.sigon.codenote.domain.message.resp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author 石光 部门：移动研发部-掌上京东
 *         Date: 14-7-18
 *         Time: 下午3:37
 *         To change this template use File | Settings | File Templates.
 * @copyright Copyright 2014-XXXX JD.COM All Right Reserved
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class TextMessage extends BaseMessage {
    // 回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
