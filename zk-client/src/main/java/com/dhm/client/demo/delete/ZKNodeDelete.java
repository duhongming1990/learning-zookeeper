package com.dhm.client.demo.delete;

import com.dhm.client.demo.connection.ZKConnect;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/9/30 10:48
 */
public class ZKNodeDelete {

    private static final ZooKeeper ZOOKEEPER = new ZKConnect(ZKConnect.connectString).getZookeeper();

    public static void main(String[] args) throws InterruptedException, KeeperException {

//        ZOOKEEPER.delete("/zk-client/delete", 0);

        String ctx = "{'delete':'success'}";
        ZOOKEEPER.delete("/zk-client/delete", 0, new DeleteCallBack(), ctx);
        Thread.sleep(2000);
    }

}