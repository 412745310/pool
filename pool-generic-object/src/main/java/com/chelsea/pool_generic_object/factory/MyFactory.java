package com.chelsea.pool_generic_object.factory;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import com.chelsea.pool_generic_object.bean.Person;

public class MyFactory extends BasePooledObjectFactory<Person> {

    @Override
    public Person create() throws Exception {
        Person person = new Person();
        person.setName(String.valueOf(Math.ceil(Math.random() * 100)));
        return person;
    }
    
    @Override
    public PooledObject<Person> wrap(Person person) {
        return new DefaultPooledObject<Person>(person);
    }

    @Override
    public boolean validateObject(PooledObject<Person> p) {
        String name = p.getObject().getName();
        System.out.println(p.getObject().getName() + " do validateObject");
        if (Float.parseFloat(name) < 80) {
            return false;
        }
        return true;
    }

    @Override
    public void activateObject(PooledObject<Person> p) throws Exception {
        System.out.println(p.getObject().getName() + " do activateObject");
    }

    @Override
    public void destroyObject(PooledObject<Person> p) throws Exception {
        System.out.println(p.getObject().getName() + " do destroyObject");
    }

}
