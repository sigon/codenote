package net.sigon.codenote.web.action;

import net.sigon.codenote.common.util.MessageUtil;
import net.sigon.codenote.common.util.WeixinValid;
import net.sigon.codenote.service.core.CoreService;
import net.sigon.codenote.service.execute.impl.FileTextExecute;
import net.sigon.codenote.web.action.base.BaseController;
import net.sigon.codenote.service.execute.JoinWeiXinExecute;
import net.sigon.codenote.web.util.WebUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 石光 部门：移动研发部-掌上京东
 *         Date: 14-6-23
 *         Time: 下午6:13
 *         To change this template use File | Settings | File Templates.
 * @copyright Copyright 2014-XXXX JD.COM All Right Reserved
 */
@Controller("clientController")
@RequestMapping("/")
public class ClientController extends BaseController {
    @Resource(name = "fileTextExecute")
    private FileTextExecute fileTextExecute;

    @Resource(name = "coreServiceImpl")
    private CoreService coreService;

    @ResponseBody
    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public String clientGet(String xml, HttpServletRequest request, HttpServletResponse response){

        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            Map<String, String> map = MessageUtil.parseXml(xml);
            return coreService.processRequest(map);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        //return "{code:1}";
    }

    @ResponseBody
    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public String clientPost(HttpServletRequest request, HttpServletResponse response){
        if(!WeixinValid.valid(WebUtil.getMap(request))){
            return "valid fail";
        }
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            //System.out.println("start");
            Map<String, String> map = MessageUtil.parseXml(request);
            //System.out.println(map.size());
            return coreService.processRequest(map);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        //return "{code:1}";
    }
    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(String param, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        try {
            return fileTextExecute.doTrans(param, new HashMap<String, String>());
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }
}
