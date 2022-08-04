package springframework.beans.factory;

import springframework.beans.BeansException;

import java.util.Map;

/**
 * BeanFactory接口的扩展，由 bean 工厂实现
 * 可以枚举其所有 bean 实例，而不是按照客户端的请求逐个尝试按名称查找 bean。
 * 预加载所有 bean 定义的 BeanFactory 实现（例如基于 XML 的工厂）可以实现此接口。
 * @author niu
 */
public interface ListableBeanFactory {

    /**
     * 按照类型返回 Bean 实例
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * Return the names of all beans defined in this registry.
     *
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();

}
