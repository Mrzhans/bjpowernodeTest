package com.bjpowernode.util;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionInvocationHandler implements InvocationHandler {
    private Object target;

    public TransactionInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession session = null;
        Object obj = null;

        try {
            session = SqlSessionUtil.getSqlSession();
            //处理业务逻辑，这是我们需要实现的业务逻辑，目标的方法
            obj = method.invoke(target, args);

            //处理业务逻辑完毕需要提交
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            SqlSessionUtil.myClose(session);
        }

        return obj;
    }

    public Object getProxy(){
        //帮我们创建李四对象，创建代理类的对象！！！！实际上我们没写
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}
