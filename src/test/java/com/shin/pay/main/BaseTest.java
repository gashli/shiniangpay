package com.shin.pay.main;

/**
 * @Author gaoshiliang
 * @Date 15/10/27.
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class BaseTest {

    @BeforeClass
    public static void initTestData() throws IOException, SQLException {
    }

    @AfterClass
    public static void afterDaoTest() {
    }

}
