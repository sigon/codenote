package net.sigon.codenote.dao.test.impl;


import net.sigon.codenote.dao.test.TestDao;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Sguang
 * Date: 14-3-17
 * Time: 12:19
 * To change this template use File | Settings | File Templates.
 */
@Repository("testDaoImpl")
public class TestDaoImpl implements TestDao {
    public String getTestValue(){
        return "中文啊啊啊abc";
    }
}
