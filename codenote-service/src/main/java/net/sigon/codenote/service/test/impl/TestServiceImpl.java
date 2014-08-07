package net.sigon.codenote.service.test.impl;

import net.sigon.codenote.dao.test.TestDao;
import net.sigon.codenote.service.test.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Sguang
 * Date: 14-3-17
 * Time: ����12:22
 * To change this template use File | Settings | File Templates.
 */
@Service("testServiceImpl")
public class TestServiceImpl implements TestService {

    @Resource(name = "testDaoImpl")
    private TestDao testDao;

    public String getTestValue(){
        return testDao.getTestValue();
    }
}
