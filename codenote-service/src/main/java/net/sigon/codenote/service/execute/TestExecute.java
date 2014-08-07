package net.sigon.codenote.service.execute;

import net.sigon.codenote.domain.json.test.TestResult;
import net.sigon.codenote.domain.util.JsonUtil;
import net.sigon.codenote.service.test.TestService;
import net.sigon.codenote.service.execute.base.BaseExecute;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author 石光 部门：移动研发部-掌上京东
 *         Date: 14-6-23
 *         Time: 下午5:35
 *         To change this template use File | Settings | File Templates.
 * @copyright Copyright 2014-XXXX JD.COM All Right Reserved
 */
public class TestExecute{

    @Resource(name="testServiceImpl")
    private TestService testService;

    public String execute(String client, Map param) throws Exception{
        TestResult result = new TestResult();
        result.setResult(testService.getTestValue());
        return JsonUtil.ObjectToJson(result);
    }
}
