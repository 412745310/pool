package com.chelsea.pool_generic_object.pool;

import org.apache.commons.pool2.impl.GenericObjectPool;

import com.chelsea.pool_generic_object.bean.Person;
import com.chelsea.pool_generic_object.config.MyPoolConfig;
import com.chelsea.pool_generic_object.factory.MyFactory;

public class MyPool extends GenericObjectPool<Person> {

    public MyPool(MyFactory factory, MyPoolConfig config) {
        super(factory, config);
    }
    
    @Override
    public Person borrowObject() throws Exception {
        synchronized (this) {
            return super.borrowObject();
        }
    }

}
