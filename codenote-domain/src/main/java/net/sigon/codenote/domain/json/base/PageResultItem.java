package net.sigon.codenote.domain.json.base;

import java.util.List;

/**
 * @author 石光 部门：移动研发部-掌上京东
 *         Date: 14-4-5
 *         Time: 上午11:58
 *         To change this template use File | Settings | File Templates.
 * @copyright Copyright 2014-XXXX JD.COM All Right Reserved
 */
public class PageResultItem<V> {
    private Integer page;
    private Integer pageSize;
    private Integer total;
    private List<V> list;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<V> getList() {
        return list;
    }

    public void setList(List<V> list) {
        this.list = list;
    }
}
