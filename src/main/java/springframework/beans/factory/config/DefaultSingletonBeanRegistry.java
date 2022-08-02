package springframework.beans.factory.config;

import java.util.HashMap;
import java.util.Map;

/**
 * 默认单例Bean注册
 * @author niu
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * 实现接口的get方法
     * @param beanName beanName
     * @return 获取的对象
     */
    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject){
        singletonObjects.put(beanName,singletonObject);
    }

}
