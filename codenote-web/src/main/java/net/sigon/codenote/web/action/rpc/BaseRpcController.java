package net.sigon.codenote.web.action.rpc;


import net.sigon.codenote.domain.json.base.BaseResult;
import net.sigon.codenote.domain.util.JsonUtil;
import net.sigon.codenote.web.action.base.BaseController;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: yf-liulei
 * Date: 14-4-11
 * Time: 2:31
 * To change this template use File | Settings | File Templates.
 */
public class BaseRpcController extends BaseController {
    private String body;
    private BaseResult result;
    private String jsonResult;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public BaseResult getResult() {
        return result;
    }

    public void setResult(BaseResult result) {
        this.result = result;
        jsonResult = JsonUtil.ObjectToRpcJson(result, null);
    }
    public void setResult(BaseResult result, Map<String, Class> classMap) {
        this.result = result;
        jsonResult = JsonUtil.ObjectToRpcJson(result, classMap);
    }

    public String getJsonResult() {
        return jsonResult;
    }
}
