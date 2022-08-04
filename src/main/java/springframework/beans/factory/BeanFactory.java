package springframework.beans.factory;

import springframework.beans.BeansException;
import springframework.beans.factory.config.BeanDefinition;

/**
 *  beanFactory接口 提供Bean的获取方法
 * @author niu
 */
public interface BeanFactory {

    /**
     * 无参
     * @param name
     * @return Bean对象
     * @throws BeansException
     */
    Object getBean(String name) throws BeansException;

    /**
     * 有参
     * @param name
     * @param args  构造参数
     * @return
     * @throws BeansException
     */
    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
