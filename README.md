# 为Bean对象注入属性和依赖Bean的功能实现

niu spring



### 一 目标

- 缺少一个关于`类中是否有属性的问题`，如果有类中包含属性那么在实例化的时候就需要把属性信息填充上，这样才是一个完整的对象创建。


### 二 设计

可以在类 `AbstractAutowireCapableBeanFactory` 的 createBean 方法中添加补全属性方法

##### 1.

属性填充要在类实例化创建之后，也就是需要在 `AbstractAutowireCapableBeanFactory` 的 createBean 方法中添加 `applyPropertyValues` 操作。

##### 2.

由于我们需要在创建Bean时候填充属性操作，那么就需要在 bean 定义 BeanDefinition 类中，添加 PropertyValues 信息。

##### 3.

另外是填充属性信息还包括了 Bean 的对象类型，也就是需要再定义一个 BeanReference，里面其实就是一个简单的 Bean 名称，在具体的实例化操作时进行递归创建和填充，与 Spring 源码实现一样。



#### 问题记载

Unable to make protected final java.lang.Class java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain) throws java.lang.ClassFormatError accessible: module java.base does not “opens java.lang” to unnamed module

解决方案： JDK8的反射相关功能被限制 9+版本 在 “Edit Configurations” 中 ——> “VM options” 输入框中输入 `--add-opens java.base/java.lang=ALL-UNNAMED` 选项来开启

![image-20220803154316732](C:\Users\niu\AppData\Roaming\Typora\typora-user-images\image-20220803154316732.png)
