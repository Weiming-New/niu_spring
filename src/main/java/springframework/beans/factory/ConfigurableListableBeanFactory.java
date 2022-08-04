package springframework.beans.factory;

import springframework.beans.BeansException;
import springframework.beans.factory.config.AutowireCapableBeanFactory;
import springframework.beans.factory.config.BeanDefinition;
import springframework.beans.factory.config.BeanPostProcessor;
import springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * 大多数listable bean工厂要实现的配置接口。
 * 除了 {@link springframework.beans.factory.config.ConfigurableBeanFactory} 之外，
 * 它还提供了分析和修改 bean 定义以及预实例化单例的工具。
 * @author niu
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
