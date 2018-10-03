# zk-dubbo

## 8 Dubbo入门到重构服务
[返回主目录](../README.md)

### 8.1 架构演变过程
![](images/ServiceFrameWork1.PNG)
![](images/ServiceFrameWork2.PNG)

### 8.2 系统之间的调用方式

废弃（很老）：Webservice-wsdl

过渡（普通）：httpclient

现在（现状）：rpc通信（Dubbo）、restful(Springcloud)

### 8.3 dubbo简介

最大程度进行解耦，降低系统耦合性

生产者/消费者模式

zk注册中心，admin监控中心，协议支持
