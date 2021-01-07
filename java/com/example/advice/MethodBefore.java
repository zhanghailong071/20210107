package com.example.advice;


import org.springframework.aop.BeforeAdvice;

import java.lang.reflect.Method;

public interface MethodBefore extends BeforeAdvice {
    void before(Method var1, Object []vars, Object var3);

}
