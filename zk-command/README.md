# zk-command

## 4 ZK基本特性与基于Linux的ZK客户端命令行学习
[返回主目录](../README.md)

### 4.1 常用命令

#### 4.1.1 状态命令
      
    ● ls与ls2
    ls path 查看znode下子节点
    ls2（ls+stat）path 查看znode下子节点和znode节点状态
    
    ● get与stat
    get path 查看znode节点数据
    stat path 查看znode节点状态

#### 4.1.2 创建命令
    create [-s] [-e] path data acl
    create [-s] [-e] path data
    
    -s 序列
    -e 临时节点
    [-s][-e]不加 永久节点

#### 4.1.3 修改命令
    set path data [version]
    
    version类似数据库乐观锁，只有当version一致才会修改，否则会报version No is not valid
#### 4.1.4 删除命令
    delete path [version]
    
    version类似数据库乐观锁，只有当version一致才会删除，否则会报version No is not valid


### 4.2 zk特性-watcher
    针对每个节点的操作，都会有一个监督者->watcher
    当监控的某个对象（znode）发生了变化，则触发watcher事件
    zk中的watcher是一次性的，触发后立即销毁
    父节点、子节点 增删改都能够触发其watcher

#### 4.2.1 父节点触发
    stat为本节点设置watcher-创建本节点触发：NodeCreated
    get为本节点设置watcher-修改本节点数据触发：NodeDataChanged
    stat为本节点设置watcher-删除本节点触发：NodeDeleted

#### 4.2.2 子节点触发
    ls/ls2为父节点设置watcher
    创建子节点触发、删除子节点触发：NodeChildrenChanged
    修改子节点不触发事件

#### 4.2.3 watcher使用场景
    统一资源配置
    
### 4.3 zk特性-acl（access control lists权限控制）

### 4.3.1 ACL命令
    getAcl获取某个节点的acl权限信息
    setAcl设置某个节点的acl权限信息
    addauth输入认证授权信息
        addauth [digest] username:password
### 4.3.2 ACL的构成
    [scheme:id:permissions]来构成权限列表
    
    scheme：代表采用的某种权限机制；
        world:anyone:[permissions]
        auth:user:password:[permissions]
        digest:username:BASE64(SHA1(password)):[permissions]
        ip:ip address:[permissions]
        super 代表超级管理员
            "-Dzookeeper.DigestAuthenticationProvider.superDigest=super:xQJmxLMiHGwaqBvst5y6rkB6HQs="
            通过addauth digest super:admin登录
            
            
    id：代表允许访问的用户
    
    permissions：权限组合字符串；
        crdwa：
            CREATE创建子节点、
            READ获取节点/子节点、
            WRITE设置节点数据、
            DELETE删除子节点、
            ADMIN设置权限
### 4.3.3 ACL的常用使用场景
    开发、测试环境分离，开发者无权操作测试库的节点，只能看。
    生产环境控制指定ip服务可以访问相关节点，防止混乱。

### 4.4 四字命令Four Letter Words
    echo [command] | nc [host] [port]
    
    zk的状态信息：echo stat | nc 127.0.0.1 2181
    zk是否启动：echo ruok | nc 127.0.0.1 2181
    列举出临时会话和临时节点：echo dump | nc 127.0.0.1 2181
    配置信息：echo conf | nc 127.0.0.1 2181
    连接信息：echo cons | nc 127.0.0.1 2181
    环境信息：echo envi | nc 127.0.0.1 2181
    健康信息：echo mntr | nc 127.0.0.1 2181
    watcher信息：echo wchs | nc 127.0.0.1 2181

    需要在zoo.cfg中配置:4lw.commands.whitelist=*
    session和watcher信息：echo wchc | nc 127.0.0.1 2181
    path和watcher信息：echo wchp | nc 127.0.0.1 2181    