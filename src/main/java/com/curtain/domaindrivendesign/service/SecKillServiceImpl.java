package com.curtain.domaindrivendesign.service;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import com.curtain.domaindrivendesign.util.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Curtain
 * @date 2018/12/19 15:25
 */
@Service
public class SecKillServiceImpl {

    @Autowired
    private RedisLock redisLock;

    static Map<String, Integer> products;
    static Map<String, Integer> stock;
    static Map<String, String> orders;

    static {
        products = new HashMap<>();
        stock = new HashMap<>();
        orders = new HashMap<>();
        products.put("1", 1000);
        stock.put("1", 1000);
    }

    public String queryMap(String productId) {
        return "商品:" + products.get(productId)
                + "还剩:" + stock.get(productId)
                + "成功下单:" + orders.size() + "人";
    }

    public  void orderProductMockDiffUser(String productId) {

        //加锁
        long time = System.currentTimeMillis() + 10000;
        boolean lock = redisLock.lock(productId, String.valueOf(time
        ));

        if (!lock) {
            throw new RuntimeException("人太多了");
        }

        //1.查询该商品库存，为0则活动结束
        int stockNum = stock.get(productId);
        if (stockNum == 0) {
            throw new RuntimeException("活动结束");
        } else {
            //2.下单
            orders.put(KeyUtil.genUniqueKey(), productId);
            //3.减库存
            stockNum = stockNum - 1;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stock.put(productId, stockNum);
        }

        //解锁
        redisLock.unlock(productId, String.valueOf(time));
    }
}
