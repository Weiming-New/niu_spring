# 设计与实现资源加载器，从Spring.xml解析和注册Bean对象

niu spring



### 一 目标

- 实际使用这个 Spring 框架，是不太可能让用户通过手动方式创建的，而是最好能通过配置文件的方式简化创建过程。
- 注册、设置属性、属性注入整合到Spring框架中，通过 Spring 配置文件的方式将 Bean 对象实例化。
- 在现有的 Spring 框架中，添加能解决 Spring 配置的读取、解析、注册Bean的操作。


### 二 设计

在现有的 Spring 框架雏形中添加一个资源解析器，也就是能读取classpath、本地文件和云文件的配置内容。这些配置内容就是像使用 Spring 时配置的 Spring.xml 一样，里面会包括 Bean 对象的描述和属性信息。在读取配置文件信息后，接下来就是对配置文件中的 Bean 描述信息解析后进行注册操作，把 Bean 对象注册到 Spring 容器中。

##### 1.

资源加载器属于相对独立的部分，它位于 Spring 框架核心包下的IO实现内容，主要用于处理Class、本地和云环境中的文件信息。

##### 2.

当资源可以加载后，接下来就是解析和注册 Bean 到 Spring 中的操作，这部分实现需要和 DefaultListableBeanFactory 核心类结合起来，因为你所有的解析后的注册动作，都会把 Bean 定义信息放入到这个类中。

##### 3.

那么在实现的时候就设计好接口的实现层级关系，包括我们需要定义出 Bean 定义的读取接口 `BeanDefinitionReader` 以及做好对应的实现类，在实现类中完成对 Bean 对象的解析和注册。



#### 问题记载

Unable to make protected final java.lang.Class java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain) throws java.lang.ClassFormatError accessible: module java.base does not “opens java.lang” to unnamed module

解决方案： JDK8的反射相关功能被限制 9+版本 在 “Edit Configurations” 中 ——> “VM options” 输入框中输入 `--add-opens java.base/java.lang=ALL-UNNAMED` 选项来开启

![image-20220803154316732](C:\Users\niu\AppData\Roaming\Typora\typora-user-images\image-20220803154316732.png)
