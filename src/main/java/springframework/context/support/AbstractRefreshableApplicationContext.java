package springframework.context.support;

import springframework.beans.BeansException;
import springframework.beans.factory.ConfigurableListableBeanFactory;
import springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * {@link springframework.context.ApplicationContext} 实现的基类，
 * 它应该支持对 {@link #refresh()} 的多次调用，
 * 通常（但不一定）每次都创建一个新的内部 bean 工厂实例。这样的上下文将由一组配置位置驱动，以从中加载 bean 定义。
 * @author niu
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    /**
     * 对资源配置的加载操作
     */
    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

}
