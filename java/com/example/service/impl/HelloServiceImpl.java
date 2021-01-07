package com.example.service.impl;

import org.springframework.aop.framework.AopContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.Future;

@Service
@EnableAsync
public class HelloServiceImpl {
    @Async
    public Future<String> getStr1() throws InterruptedException {
        Thread.sleep(3000);
        return new AsyncResult<>("===001"+System.currentTimeMillis()) ;
    }
    @Async
    public Future<String> getStr2() throws InterruptedException {
        Thread.sleep(6000);
        return new AsyncResult<>("===002"+System.currentTimeMillis()) ;
    }
    public String getStr3() throws InterruptedException {
        Thread.sleep(3000);
        return ("===003"+Thread.currentThread().getName()) ;
    }
    public String getStr4() throws InterruptedException {
        Thread.sleep(3000);
        return ("===004"+Thread.currentThread().getName()) ;
    }
    @Async
    public void setStr1() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("====set001======"+Thread.currentThread().getName());
    }
    @Async
    public void setStr2() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("====set002======"+Thread.currentThread().getName());
    }
    @Transactional
    public void setStr3() throws InterruptedException {
        HelloServiceImpl service=(HelloServiceImpl) AopContext.currentProxy();
        System.out.println("service。。。"+service);
        System.out.println("主线程开始。。。");
        service.setStr1();
        service.setStr2();
        System.out.println("主线程结束。。。");
    }
}
