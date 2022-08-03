package springframework.beans.factory.support;

import springframework.beans.BeansException;
import springframework.beans.factory.BeanFactory;
import springframework.beans.factory.config.BeanDefinition;
import springframework.beans.factory.config.DefaultSingletonBeanRegistry;

/**
 * BeanFactory抽象类 继承单例 实现beanFactory接口的getBean方法
 * 定义了两个抽象方法：getBeanDefinition()、createBean()
 * 两个抽象方法分别由 DefaultListableBeanFactory、AbstractAutowireCapableBeanFactory 实现
 * @author niu
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeansException {
        return  doGetBean(name,null);
    }

    @Override
    public Object getBean(String name,Object... args) throws BeansException {
        return  doGetBean(name,args);
    }

    protected Object doGetBean(String name,Object[] args){
        Object bean = getSingleton(name);
        if(bean!=null){
            return bean;
        }

        //不存在 进行创建
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return  creatBean(name,beanDefinition,args);
    }

    protected  abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected  abstract Object creatBean(String beanName, BeanDefinition beanDefinition,Object[] args) throws BeansException;


}
