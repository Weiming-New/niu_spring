package springframework.beans.factory.config;

import springframework.beans.factory.HierarchicalBeanFactory;

/**
 * 提供配置bean工厂的工具
 * @author niu
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
