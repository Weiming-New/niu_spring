package springframework.beans.factory.support;

import springframework.beans.BeansException;
import springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实现Bean的实例化操作 newInstance TODO 有改造函数入参怎么办？
 * @author niu
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private  InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();
    /**
     *  根据Name 和definition 创建 Bean
     * @param beanName 名字
     * @param beanDefinition 定义
     * @return 创建好的Bean
     * @throws BeansException
     */
    @Override
    protected Object creatBean(String beanName, BeanDefinition beanDefinition,Object[] args) throws BeansException {
        Object bean = null;
        try{
            bean = createBeanInstance(beanDefinition,beanName,args);
        }catch (Exception e){
            throw new BeansException("Instantiation of bean failed",e);
        }
        addSingleton(beanName,bean);
        return bean;
    }

    /**
     *  取代版本1中 没有参数的直接newInstance
     * @param beanDefinition
     * @param beanName
     * @param args
     * @return 创建好的bean
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args){
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for(Constructor ctor : declaredConstructors){
            // 此时只简单比较长度
            if(null!=args&&ctor.getParameterTypes().length == args.length){
                constructorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition,beanName,constructorToUse,args);
    }


    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }
}
