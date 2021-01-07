package com.example.controller;

import com.example.advice.CountTimes;
import com.example.service.impl.HelloServiceImpl;
import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.Advised;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class HelloController {
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
private HelloServiceImpl service;
    @RequestMapping("/hello")
    public String hello() throws InterruptedException, ExecutionException {
       Future f1=service.getStr1();
        Future f2=service.getStr2();
        System.out.println("异步执行完成。。。。"+System.currentTimeMillis());
        try {
            long startTime=System.currentTimeMillis();   //获取开始时间            System.out.println("方法1开始运行。。。。"+f1.get());

            System.out.println("主线程开始运行。。。。"+startTime);
            System.out.println("方法1开始运行。。。。"+f1.get()+"====="+System.currentTimeMillis());
            System.out.println("方法2开始运行。。。。"+f2.get()+"====="+System.currentTimeMillis());
            long endTime=System.currentTimeMillis();   //获取开始时间            System.out.println("方法1开始运行。。。。"+f1.get());
            System.out.println("主线程开始运行。。。。"+endTime);
            System.out.println("主线程运行耗时。。。。"+(endTime-startTime));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello.....";
    }
    @GetMapping("/advice")
    public void set() throws InterruptedException {
        Advice advice=new CountTimes();
        UserController usercontroller=(UserController)applicationContext.getBean("UserController");
        ((Advised)usercontroller).addAdvice(advice);
        System.out.println("执行成功。。。。。。。");
    }
}
