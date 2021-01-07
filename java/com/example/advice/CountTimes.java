package com.example.advice;

import java.lang.reflect.Method;

public class CountTimes implements MethodBefore {
    private int count;
    protected void count(Method m ){
        count++;
    }

    @Override
    public void before(Method m, Object[] vars, Object var3) {
            count(m);
        System.out.println("方法名===="+m.getName()+"次数是===="+count);
    }
}
