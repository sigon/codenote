package net.sigon.codenote.web.action;

import net.sigon.codenote.service.test.TestService;
import net.sigon.codenote.web.action.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Sguang
 * Date: 14-3-16
 * Time: 11:17
 * To change this template use File | Settings | File Templates.
 */
@Controller("testController")
@RequestMapping("/test")
public class TestController extends BaseController {

    @Resource(name = "testServiceImpl")
    private TestService testService;


    /**
     * 127.0.0.1/test/method/21.action
     * @param id
     * @param model
     * @param json
     * @return
     */
    @RequestMapping(value = "/method/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public String list(@PathVariable Long id, ModelMap model, String json) {
        model.addAttribute("str", "SPRING MVC");
        model.addAttribute("id", id);
        model.addAttribute("testValue", testService.getTestValue());

        return "/test/method";
    }


}
