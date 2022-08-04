# 实现应用上下文，自动识别、资源加载、扩展机制

niu spring



### 一 目标

- DefaultListableBeanFactory、XmlBeanDefinitionReader，是我们在目前 Spring 框架中对于服务功能测试的使用方式，它能很好的体现出 Spring 是如何对 xml 加载以及注册Bean对象的操作过程，但这种方式是面向 Spring 本身的，还不具备一定的扩展性。
- 就像我们现在需要提供出一个可以在 Bean 初始化过程中，完成对 Bean 对象的扩展时，就很难做到自动化处理。所以我们要把 Bean 对象扩展机制功能和对 Spring 框架上下文的包装融合起来，对外提供完整的服务。


### 二 设计

在现有的 Spring 框架雏形中添加一个资源解析器，也就是能读取classpath、本地文件和云文件的配置内容。这些配置内容就是像使用 Spring 时配置的 Spring.xml 一样，里面会包括 Bean 对象的描述和属性信息。在读取配置文件信息后，接下来就是对配置文件中的 Bean 描述信息解析后进行注册操作，把 Bean 对象注册到 Spring 容器中。

##### 1.

满足于对 Bean 对象扩展的两个接口，其实也是 Spring 框架中非常具有重量级的两个接口：`BeanFactoryPostProcess` 和 `BeanPostProcessor`，也几乎是大家在使用 Spring 框架额外新增开发自己组建需求的两个必备接口。

##### 2.

BeanFactoryPostProcessor，是由 Spring 框架组建提供的容器扩展机制，允许在 Bean 对象注册后但未实例化之前，对 Bean 的定义信息 `BeanDefinition` 执行修改操作。

##### 3.

BeanPostProcessor，也是 Spring 提供的扩展机制，不过 BeanPostProcessor 是在 Bean 对象实例化之后修改 Bean 对象，也可以替换 Bean 对象。这部分与后面要实现的 AOP 有着密切的关系。

##### 4.

同时如果只是添加这两个接口，不做任何包装，那么对于使用者来说还是非常麻烦的。我们希望于开发 Spring 的上下文操作类，把相应的 XML 加载 、注册、实例化以及新增的修改和扩展都融合进去，让 Spring 可以自动扫描到我们的新增服务，便于用户使用。



#### 问题记载

bean实例化时的改变失败

原因：未在AbstractAutowireCapableBeanFactory的creatBean中添加对应改变方法

