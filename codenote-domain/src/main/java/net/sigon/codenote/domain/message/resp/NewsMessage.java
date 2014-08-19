package net.sigon.codenote.domain.message.resp;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author 石光 部门：移动研发部-掌上京东
 *         Date: 14-7-18
 *         Time: 下午3:38
 *         To change this template use File | Settings | File Templates.
 * @copyright Copyright 2014-XXXX JD.COM All Right Reserved
 */
@XmlRootElement(name = "xml")
public class NewsMessage extends BaseMessage {
    // 图文消息个数，限制为10条以内
    @XmlElement
    private int ArticleCount;
    // 多条图文消息信息，默认第一个item为大图
    @XmlElement
    private Articles Articles;

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public Articles getArticles() {
        return Articles;
    }

    public void setArticles(Articles articles) {
        Articles = articles;
    }
}
