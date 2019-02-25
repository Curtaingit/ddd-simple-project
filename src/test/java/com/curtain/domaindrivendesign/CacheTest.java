package com.curtain.domaindrivendesign;

import com.curtain.domaindrivendesign.service.ValueService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Curtain
 * @date 2019/1/2 10:26
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheTest {
/*    private final Map<String, String> map = new HashMap<>();

    {
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("5", "5");
    }

    //不生效
    @Cacheable(value = "test", key = "#key")
    public String get(String key) {
        return map.get(key);
    }*/

    @Autowired
    ValueService valueService;


    /**
     * 同一个类中的方法调用  缓存不生效   需要注入 service这种模式
     */
    @Test
    public void test(){
        for (int i=0;i<3;i++){
            String s = valueService.get("5");
            System.out.println(s);
        }
    }
}

