package net.sigon.codenote.domain.exception;

/**
 * @author 石光 部门：移动研发部-掌上京东
 *         Date: 14-4-4
 *         Time: 下午5:56
 *         To change this template use File | Settings | File Templates.
 * @copyright Copyright 2014-XXXX JD.COM All Right Reserved
 */
public class BusinessException extends Exception {
    public BusinessException(String msg){
        super(msg);
    }
}
