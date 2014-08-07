package net.sigon.codenote.web.action.base;

import net.sigon.codenote.domain.common.Client;

/**
 * Created with IntelliJ IDEA.
 * User: Sguang
 * Date: 14-3-16
 * Time: 下午11:17
 * To change this template use File | Settings | File Templates.
 */
public class BaseController {

    protected static String SUCCESS = "success";
    protected static String ERROR = "error";

    /** 每页记录数 */
    private static final int PAGE_SIZE = 20;

    private Long userId;
    private Client client;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
