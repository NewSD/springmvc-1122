package com.niu;

import com.niu.service.ItemsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.swing.*;

/**
 * Created by ami on 2018/11/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext-*.xml",
                        "classpath:/spring/springmvc.xml"
})
public class App {

    @Resource
    private ItemsService itemsService;

    @Test
    public void testService() {
        System.out.println("Hello World!");
        System.out.println(itemsService);

    }
}
