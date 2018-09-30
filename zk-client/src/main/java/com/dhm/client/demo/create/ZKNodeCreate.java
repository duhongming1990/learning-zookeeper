package com.dhm.client.demo.create;

import com.dhm.client.demo.connection.ZKConnect;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;

import java.io.IOException;
import java.util.List;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/9/30 9:17
 */
@Slf4j
public class ZKNodeCreate extends ZKConnect{
    private static final ZooKeeper ZOOKEEPER = new ZKConnect(ZKConnect.connectString).getZookeeper();
    /**
     *
     * @Title: ZKOperatorDemo.java
     * @Description: 创建zk节点
     */
    public void createZKNode(String path, String data, List<ACL> acls) {

        String result;
        try {
            /**
             * 同步或者异步创建节点，都不支持子节点的递归创建，异步有一个callback函数
             * 参数：
             * path：创建的路径
             * data：存储的数据的byte[]
             * acl：控制权限策略
             * 			Ids.OPEN_ACL_UNSAFE --> world:anyone:cdrwa
             * 			CREATOR_ALL_ACL --> auth:user:password:cdrwa
             * createMode：节点类型, 是一个枚举
             * 			PERSISTENT：持久节点
             * 			PERSISTENT_SEQUENTIAL：持久顺序节点
             * 			EPHEMERAL：临时节点
             * 			EPHEMERAL_SEQUENTIAL：临时顺序节点
             */

            //同步
            result = ZOOKEEPER.create(path, data.getBytes(), acls, CreateMode.PERSISTENT);
            System.out.println("创建节点：\t" + result + "\t成功...");

            //异步
//			String ctx = "{'create':'success'}";
//			ZOOKEEPER.create(path, (data+"-callback").getBytes(), acls, CreateMode.PERSISTENT, new CreateCallBack(), ctx);
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ZKNodeCreate zkNodeCreate = new ZKNodeCreate();
        // 创建zk节点
        zkNodeCreate.createZKNode("/zk-client", "create-node", ZooDefs.Ids.OPEN_ACL_UNSAFE);
    }
}