package com.dhm.client.demo.set;

import com.dhm.client.demo.connection.ZKConnect;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/9/30 9:38
 */
public class ZKNodeSet extends ZKConnect {
    private static final ZooKeeper ZOOKEEPER = new ZKConnect(ZKConnect.connectString).getZookeeper();

    public Stat setZKNode(String path,byte[] data,int version) throws KeeperException, InterruptedException {
        return ZOOKEEPER.setData(path,data,version);
    }

    public void setZKnode(String path,byte[] data,int version) throws InterruptedException {
        String ctx = "{'create':'success'}";
        ZOOKEEPER.setData(path,data,version,new SetCallBack(),ctx);
        Thread.sleep(2000);
    }

    public static void main(String[] args) throws KeeperException, InterruptedException {
        ZKNodeSet zkNodeSet = new ZKNodeSet();

        /**
         * 参数：
         * path：节点路径
         * data：数据
         * version：数据状态
         */
//		Stat status  = zkNodeSet.setZKNode("/zk-client", "set-node".getBytes(), 0);
//		System.out.println(status.getVersion());


        zkNodeSet.setZKnode("/zk-client", "set-node-callback".getBytes(), 1);
    }
}