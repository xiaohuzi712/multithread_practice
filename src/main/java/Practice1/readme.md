## Thread实践笔记

#### 1.基础知识
1.  线程共有5个状态，分别是新建态、就绪态、运行态、阻塞态、死亡态
2.  CPU轮转机制
3.  创建线程的方法:1.继承Thread类，重写run方法，然后new出Thread子类。2.
实现Runnable接口，重写run方法,然后以该实例作为Thread的target。3.实现
Callable接口，重写call方法，将Mycallable实例对象作为FutureTask的target,
同时Thread包装FutureTask对象。
4.  Runnable接口和Callable接口的区别，Runable无返回值，而Callable有返回值
并且结合FurureTask获取获取Callable中执行体的结果。
5.  不能对同一线程实调用两次start方法。
6.  FutureTask的调用get()方法会处于阻塞状态，直到子线程call()方法执行完毕

#### 2.源码阅读



#### 3.线程状态图
![线程状态图](status.png  "The status of Thread")
