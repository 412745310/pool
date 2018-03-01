package com.chelsea.pool_generic_object.bean;

public class Person {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void work() throws Exception {
        System.out.println(name + " do work ");
        Thread.sleep(3000);
    }

}
