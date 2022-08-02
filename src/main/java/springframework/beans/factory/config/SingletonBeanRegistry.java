package springframework.beans.factory.config;

/**
 * 单例注册接口
 * @author niu
 */
public interface SingletonBeanRegistry {

    /**
     * 获取单例对象
     * @param beanName beanName
     * @return 单例实例
     */
    Object getSingleton(String beanName);
}
