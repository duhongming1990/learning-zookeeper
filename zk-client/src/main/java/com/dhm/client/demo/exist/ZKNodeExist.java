package com.dhm.client.demo.exist;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import com.dhm.client.demo.connection.ZKConnect;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * @Description: zookeeper 判断阶段是否存在demo
 */
public class ZKNodeExist implements Watcher {
    private static final ZooKeeper ZOOKEEPER = new ZKConnect(ZKConnect.connectString).getZookeeper();

	private static CountDownLatch countDown = new CountDownLatch(1);
	
	public static void main(String[] args) throws Exception {

		/**
		 * 参数：
		 * path：节点路径
		 * watch：watch
		 */
		Stat stat = ZOOKEEPER.exists("/imooc-fake", true);
		if (stat != null) {
			System.out.println("查询的节点版本为dataVersion：" + stat.getVersion());
		} else {
			System.out.println("该节点不存在...");
		}
		
		countDown.await();
	}
	
	@Override
	public void process(WatchedEvent event) {
		if (event.getType() == EventType.NodeCreated) {
			System.out.println("节点创建");
			countDown.countDown();
		} else if (event.getType() == EventType.NodeDataChanged) {
			System.out.println("节点数据改变");
			countDown.countDown();
		} else if (event.getType() == EventType.NodeDeleted) {
			System.out.println("节点删除");
			countDown.countDown();
		}
	}

}

