package net.sigon.codenote.domain.json.base;


/**
 * @author 石光 部门：移动研发部-掌上京东
 *         Date: 14-4-5
 *         Time: 上午11:57
 *         To change this template use File | Settings | File Templates.
 * @copyright Copyright 2014-XXXX JD.COM All Right Reserved
 */
public class PageResult<V> extends BaseResult {
    private PageResultItem<V> result;

    public PageResultItem<V> getResult() {
        return result;
    }

    public void setResult(PageResultItem<V> result) {
        this.result = result;
    }
}
