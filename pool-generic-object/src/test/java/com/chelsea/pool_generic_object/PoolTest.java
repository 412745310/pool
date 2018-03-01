package com.chelsea.pool_generic_object;

import com.chelsea.pool_generic_object.bean.Person;
import com.chelsea.pool_generic_object.config.MyPoolConfig;
import com.chelsea.pool_generic_object.factory.MyFactory;
import com.chelsea.pool_generic_object.pool.MyPool;

public class PoolTest {

    public static void main(String[] args) throws Exception {
        // 实例化配置类
        MyPoolConfig myPoolConfig = new MyPoolConfig();
        // 设置最大工作人数
        myPoolConfig.setMaxTotal(1);
//        myPoolConfig.setTestOnCreate(true);
        myPoolConfig.setTestOnBorrow(true);
        // myPoolConfig.setTestOnReturn(true);
        // 设置阻塞最大等待毫秒数
//         myPoolConfig.setMaxWaitMillis(100);
        MyPool myPool = new MyPool(new MyFactory(), myPoolConfig);
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    Person p = null;
                    try {
                        p = myPool.borrowObject();
                        p.work();
                        myPool.returnObject(p);
                    } catch (Exception e) {
                        System.out.println(Thread.currentThread().getName() + " " + e.getMessage());
                    }
                }
            };
            t.setName("thread" + i);
            t.start();
        }
    }

}
