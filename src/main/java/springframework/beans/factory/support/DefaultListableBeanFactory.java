package springframework.beans.factory.support;

import springframework.beans.BeansException;
import springframework.beans.factory.config.BeanDefinition;
import springframework.beans.factory.config.BeanDefinitionRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 核心类  接口类定义了注册 抽象类定义了获取
 * @author niu
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private Map<String,BeanDefinition> beanDefinitionMap = new HashMap<>();
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName,beanDefinition);
    }

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if(beanDefinition==null){
            throw new BeansException("No bean named '"+beanName+"' is defined");
        }
        return beanDefinition;
    }
}
