package net.sigon.codenote.web.interceptor;

import net.sigon.codenote.domain.common.Result;
import net.sigon.codenote.domain.constant.Constant;
import net.sigon.codenote.domain.exception.BusinessException;
import net.sigon.codenote.domain.util.JsonUtil;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * @author 石光
 *         Date: 14-4-4
 *         Time: 下午6:01
 *         To change this template use File | Settings | File Templates.
 * @copyright Copyright 2014-XXXX JD.COM All Right Reserved
 */
public class RpcBusinessExceptionInterceptor extends HandlerInterceptorAdapter {

    private static final Logger log = Logger.getLogger(RpcBusinessExceptionInterceptor.class);

    @SuppressWarnings("unchecked")
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        if(ex instanceof BusinessException){
            try {
                Result result = new Result();
                result.setSuccess(false);
                result.setCode(Constant.RESULT_TRANSERROR);
                result.setMsg(ex.getMessage());
                response.setCharacterEncoding("UTF-8");
                Writer writer = response.getWriter();
                writer.append(JsonUtil.ObjectToJson(result));
                writer.close();
            } catch (IOException e) {
                log.error("BusinessExceptionInterceptor error", e);
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        return;
    }
}
