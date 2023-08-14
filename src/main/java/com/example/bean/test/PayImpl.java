package com.example.bean.test;

public class PayImpl implements Pay{
    private final Hello hello;
    private final Discount discount;
    
    public PayImpl(Hello hello, Discount discount) {
        this.hello = hello;
        this.discount = discount;
    }

    @Override
    public void pay() {
        System.out.println("FROM PayImpl => hello + discount");
        hello.sayHello();
        discount.discount();

    }
}
