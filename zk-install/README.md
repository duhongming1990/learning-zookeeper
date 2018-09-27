# zk-install

## 2 zk安装
[返回主目录](../README.md)

### 2.1 zookeeper文件夹主要目录介绍

    bin：主要运行的命令
    conf：存放配置文件，需要修改zk.cfg
    contrib：附加的一些功能
    dist-maven：maven编译后的目录
    docs：文档
    lib：需要依赖的jar包
    recipes：案例demo代码
    src：源码

### 2.2 zookeeper配置文件介绍
配置环境变量：JAVA、ZK。

    # The number of milliseconds of each tick
    # 用于计算的时间单元：2s，比如session超时：N*tickTime
    tickTime=2000
    
    # The number of ticks that the initial 
    # synchronization phase can take
    # 用于集群，运行从节点连接并同步到主节点的初始化连接时间
    # 以tickTime的整数倍表示：20s
    initLimit=10
    
    # The number of ticks that can pass between 
    # sending a request and getting an acknowledgement
    # 用于集群，主节点和子节点之间发送消息
    # 请求和应答的时间长度：10s。（心跳机制）
    syncLimit=5
    
    # the directory where the snapshot is stored.
    # do not use /tmp for storage, /tmp here is just 
    # example sakes.
    # 数据目录
    dataDir=E:\\Program Files\\zookeeper\\data
    
    # 日志目录，如果不配置和dataDir公用
    dataLogDir=E:\\Program Files\\zookeeper\\log
    
    # the port at which the clients will connect
    # 连接服务器的端口号
    clientPort=2181


### 2.3 运行zk   
    windows:双击zkServer.cmd
    linux：./zkServer.sh start
    
