# zk-cluster

##  5 选举模式和ZooKeeper的集群安装
[返回主目录](../README.md)

### 5.1  集群的一些基本概念
    zk集群，主从节点，心跳机制（选举模式）:
    
    xx：Master、yy：Slave1、zz：Slave2
    当通过心跳机制发现xx挂掉后，yy和zz通过选举模式，竞争胜利的成为yy：Master，竞争失败的成为zz：Slave1
    当xx恢复后，yy还是Master节点，yy：Master、zz：Slave1、xx：Slave2

### 5.2 安装zookeeper集群

### 5.2.1 修改ZooKeeper配置文件
    clientPort=2181
    #数据同步端口、通过心跳机制选举端口
    server.1=dc1:2888:3888
    server.2=dc2:2888:3888
    server.3=dc3:2888:3888
### 5.2.2 创建data目录并设置myid,内容分别为1,2,3

     
    