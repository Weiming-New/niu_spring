package springframework.beans.factory;

import springframework.beans.factory.config.BeanDefinition;

/**
 *  beanFactory接口 提供Bean的获取方法
 * @author niu
 */
public interface BeanFactory {

    public Object getBean(String name);



}
