# 基于Cglib实现含构造函数的类实例化策略

niu spring



### 一 目标

- 实例化对象的代码里并没有考虑对象类是否含构造函数，也就是说如果去实例化一个含有构造函数的对象那么就要抛异常了

  ![image-20220802134047231](C:\Users\niu\AppData\Roaming\Typora\typora-user-images\image-20220802134047231.png)

![image-20220802134026042](C:\Users\niu\AppData\Roaming\Typora\typora-user-images\image-20220802134026042.png)

发生这一现象的主要原因就是因为 `beanDefinition.getBeanClass().newInstance();` 实例化方式并没有考虑构造函数的入参，那么就要解决这个问题。

### 二 设计

##### 问题：1.流程从哪合理的把构造函数的入参信息传递到实例化操作

##### 			2.怎么去实例化含有构造函数的对象

##### 1.

参考 Spring Bean 容器源码的实现方式，在 BeanFactory 中添加 `Object getBean(String name, Object... args)` 接口，这样就可以在获取 Bean 时把构造函数的入参信息传递进去了。

##### 2.

另外一个核心的内容是使用什么方式来创建含有构造函数的 Bean 对象呢？这里有两种方式可以选择，一个是基于 Java 本身自带的方法 `DeclaredConstructor`，另外一个是使用 Cglib 来动态创建 Bean 对象



#### 问题记载

Unable to make protected final java.lang.Class java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain) throws java.lang.ClassFormatError accessible: module java.base does not “opens java.lang” to unnamed module

解决方案： JDK8的反射相关功能被限制 9+版本 在 “Edit Configurations” 中 ——> “VM options” 输入框中输入 `--add-opens java.base/java.lang=ALL-UNNAMED` 选项来开启

![image-20220803154316732](C:\Users\niu\AppData\Roaming\Typora\typora-user-images\image-20220803154316732.png)
