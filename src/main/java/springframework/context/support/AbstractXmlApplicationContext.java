package springframework.context.support;

import springframework.beans.factory.support.DefaultListableBeanFactory;
import springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * {@link springframework.context.ApplicationContext} 实现的便捷基类
 * 处理了关于 XML 文件配置信息的操作
 * @author niu
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();

}
