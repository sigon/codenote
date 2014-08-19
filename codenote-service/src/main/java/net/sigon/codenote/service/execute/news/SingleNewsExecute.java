package net.sigon.codenote.service.execute.news;

import net.sigon.codenote.domain.message.resp.Article;
import net.sigon.codenote.service.execute.base.NewsExecute;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Sguang
 * Date: 14-8-19
 * Time: 下午11:43
 * To change this template use File | Settings | File Templates.
 */
@Service("singleNewsExecute")
public class SingleNewsExecute extends NewsExecute {
    @Override
    public List<Article> getArticleList(String param, Map<String, String> map) {
        List<Article> list = new ArrayList<Article>();
        Article article = new Article();
        article.setTitle("标题");
        article.setDescription("描述");
        article.setPicUrl("http://g.hiphotos.baidu.com/image/pic/item/c9fcc3cec3fdfc03a4824223d63f8794a5c226b6.jpg");
        article.setUrl("http://baike.baidu.com/view/281568.htm");
        list.add(article);
        return list;
    }
}
