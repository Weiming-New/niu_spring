package test;

import springframework.bean.UserService;
import springframework.beans.factory.config.BeanDefinition;
import springframework.beans.factory.BeanFactory;
import org.junit.Test;
import springframework.beans.factory.support.DefaultListableBeanFactory;

public class ApiTest {

    @Test
    public void test_BeanFactory(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService","niu");
        userService.queryUserInfo();
        // 4.第二次获取 bean from singleton
        UserService userService_singleton = (UserService) beanFactory.getBean("userService","niu");
        userService_singleton.queryUserInfo();

    }

}
