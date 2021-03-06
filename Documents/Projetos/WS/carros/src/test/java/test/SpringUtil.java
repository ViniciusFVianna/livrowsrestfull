/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import org.springframework.beans.BeansException;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Vinicius.Vianna
 */
public class SpringUtil {
    private static SpringUtil instance;
    protected AbstractXmlApplicationContext ctx;
    private SpringUtil(){
        try {
            ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        } catch (BeansException e) {
            e.printStackTrace();
            throw e;
        }
}//fecha construtor
    
    public static SpringUtil getInstance(){
        if (instance == null) {
            instance = new SpringUtil();
        }
        return instance;
    }
    @SuppressWarnings("rawtypes")
    public Object getBean(Class c){
        if (ctx == null) {
            return null;
        }
        String[] beanNamesForType = ctx.getBeanNamesForType(c);
        if (beanNamesForType == null || beanNamesForType.length == 0) {
            return null;
        }
        String name = beanNamesForType[0];
        Object bean = getBean(name);
        return bean;
    }
    public Object getBean(String name){
        if (ctx == null) {
            return null;
        }
        Object bean = ctx.getBean(name);
        return bean;
    }
}//fehca classe