package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Random;

@RestController
public class UserController {
    @RequestMapping("SSE")
    @ResponseBody
    public DeferredResult <String>getMsg() throws InterruptedException {
        DeferredResult <String> msg=new DeferredResult();
       // Thread.sleep(100);
        msg.setResult("msg==="+System.currentTimeMillis());
        return msg;
    }

    @ResponseBody
    @RequestMapping("/testHeool")
    public String hello(String name){
        return "Hello...."+name;
    }

    @RequestMapping(value="needPrice")
    @ResponseBody
    public void push1(HttpServletResponse response){
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("utf-8");
        Random r = new Random();
        int sendCount = 0;/*服务器数据发送完*/
        try {
            PrintWriter pw = response.getWriter();
            while(true){
                if(pw.checkError()){
                    System.out.println("客户端断开连接");
                    return;
                }
                Thread.sleep(1000);
                //字符串拼接
                StringBuilder sb = new StringBuilder("");
                sb//.append("retry:2000\n")
                        .append("data:")
                        .append((r.nextInt(1000)+50)+",")
                        .append((r.nextInt(800)+100)+",")
                        .append((r.nextInt(2000)+150)+",")
                        .append((r.nextInt(1500)+100)+",")
                        .append("\n\n");

                pw.write(sb.toString());
                pw.flush();
                sendCount++;
                System.out.println("========="+Thread.currentThread().getName());
                if(sendCount>=100){
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
