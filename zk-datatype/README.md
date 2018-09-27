# zk-datatype

## 3 zk基本数据类型
[返回主目录](../README.md)

### 3.1 zookeeper基本数据模型介绍
      ● zk的数据模型也可以理解为linux/unix的文件目录
      ● 每一个节点都称之为znode，它可以有子节点，也可以有数据
      ● 每个节点分为临时节点和永久节点，临时节点在客户端断开后消失
      ● 每个zk节点都各自的版本号，可以通过命令行来显示节点信息
      ● 每当节点数据发生变化，那么该节点的版本号会累加（乐观锁）
      ● 删除/修改过时节点，版本号不匹配则会报错
      ● 每个zk节点存储的数据不宜过大，几K即可
      ● 节点可以设置权限acl，可以通过权限来限制用户的访问

### 3.2 zookeeper作用
      ● master节点选举，主节点挂了以后，从节点就会接手工作，并且保证这个节点是唯一的，这也是所谓首脑模式，从而保证我们的集群是高可用的。
      ● 统一配置文件管理。
      ● 发布与订阅，类似消息队列MQ（amq、rmq），dubbo发布者把数据存在znode上，订阅者会读取这个数据。
      ● 提供分布式锁。
      ● 集群管理，保证数据的强一致性
