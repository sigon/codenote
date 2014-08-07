package net.sigon.codenote.service.core;

import java.util.Map;

/**
 * 核心服务类
 */
public interface CoreService {
    /**
     * 处理微信发来的请求
     *
     * @param requestMap
     * @return
     */
    public String processRequest(Map<String, String> requestMap);
}
