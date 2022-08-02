package springframework.beans.factory.support;

import springframework.beans.BeansException;
import springframework.beans.factory.config.BeanDefinition;

/**
 * 实现Bean的实例化操作 newInstance TODO 有改造函数入参怎么办？
 * @author niu
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    /**
     *  根据Name 和definition 创建 Bean
     * @param beanName 名字
     * @param beanDefinition 定义
     * @return 创建好的Bean
     * @throws BeansException
     */
    @Override
    protected Object creatBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try{
            bean = beanDefinition.getBeanClass().newInstance();
        }catch (InstantiationException|IllegalAccessException e){
            throw new BeansException("Instantiation of bean failed",e);
        }
        addSingleton(beanName,bean);
        return bean;
    }


}
