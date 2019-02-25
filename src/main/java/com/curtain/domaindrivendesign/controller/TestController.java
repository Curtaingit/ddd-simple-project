package com.curtain.domaindrivendesign.controller;

import com.curtain.domaindrivendesign.domain.User;
import com.curtain.domaindrivendesign.domain.events.TestEvent;


import com.curtain.domaindrivendesign.repository.UserRepository;
import com.curtain.domaindrivendesign.service.SecKillServiceImpl;
import com.curtain.domaindrivendesign.service.UserService;
import com.curtain.domaindrivendesign.util.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Curtain
 * @date 2018/12/18 15:49
 */

@RestController
public class TestController {

    private final ApplicationContext applicationContext;
    private final UserRepository repository;
    private final SecKillServiceImpl secKillService;

    @Autowired
    public TestController(final ApplicationContext applicationContext, final UserRepository userRepository, final SecKillServiceImpl secKillService) {
        this.applicationContext = applicationContext;
        this.repository = userRepository;
        this.secKillService = secKillService;
    }

    @Autowired
    private KafkaSender kafkaSender;


    @RequestMapping("/testEvent")
    public void testEvent() {
        TestEvent test = new TestEvent(this, "test");
        applicationContext.publishEvent(test);
        System.out.println("事件发布成功");
    }

    @RequestMapping("/saveUser")
    public Object saveUser() {
        User user = new User();
        user.setPassword("1");
        user.setNickname("aha");
        user.setPhone("xx");

        return repository.save(user);

    }

    @RequestMapping("/query")
    @Cacheable(value="users", key="#id")
    public Object query(@RequestParam("id") String id) {
        get("2");
        return secKillService.queryMap(id);
    }

    @RequestMapping("/createOrder")
    public void createOrder(@RequestParam("id") String id) {
        secKillService.orderProductMockDiffUser(id);
    }



    private final Map<String, String> map = new HashMap<>();

    {
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("5", "5");
    }

    public String values(String key) {
        return map.get(key);
    }

    @Cacheable(value="test", key="#key")
    public void get(String key){
        String values = values(key);
        System.out.println(values);
    }

//    @RequestMapping("/send")
//    public Object send() {
//        kafkaSender.send("hello kafka");
//        return "发送成功";
//    }
}
