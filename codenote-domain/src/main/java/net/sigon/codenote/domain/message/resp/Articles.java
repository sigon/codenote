package net.sigon.codenote.domain.message.resp;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sguang
 * Date: 14-8-20
 * Time: 上午12:31
 * To change this template use File | Settings | File Templates.
 */
public class Articles {
    @XmlElement
    private List<Article> item;


    public void setItem(List<Article> item) {
        this.item = item;
    }
}
