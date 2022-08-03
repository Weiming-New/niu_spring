package springframework.beans.factory.support;

import springframework.beans.BeansException;
import springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化策略接口
 * @author niu
 */
public interface InstantiationStrategy {
    /**
     * 实例化方法
     * @param beanDefinition
     * @param beanName
     * @param ctor reflect 包下的 Constructor 类，里面包含了一些必要的类信息，目的就是为了拿到符合入参信息相对应的构造函数。
     * @param args
     * @return
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args)
            throws BeansException;
}
