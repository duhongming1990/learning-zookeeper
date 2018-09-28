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
    