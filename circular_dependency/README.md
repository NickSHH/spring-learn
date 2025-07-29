# Spring Circular Dependency

先创建AService，执行AService的生命周期
1、实例化AService --> 得到一个对象 --> singletonFactories<AService: Lambda<AService原始对象>>
2、填充BService属性 --> 去单例池中找BService --> 没有则创建BService
3、填充其他属性
4、初始化前、初始化
5、初始化后
6、放入单例池



先创建BService，执行BService的生命周期
1、实例化BService --> 得到一个对象
2、填充AService属性 --> 去单例池中找AService --> 判断AService是否经过完整生命周期 --> 出现循环依赖 --> earlySingletonObjects --> singletonFactories --> Lambda -->执行AOP --> earlySingletonObjects
3、填充其他属性
4、初始化前、初始化
5、初始化后
6、放入单例池



三级缓存：
1、singletonObjects: 单例池
2、earlySingletonObjects
3、singletonFactories

额外：
1、singletonsCurrentlyInCreation