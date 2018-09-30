package com.dhm.client.demo.get;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import com.dhm.client.demo.connection.ZKConnect;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.Watcher.Event.EventType;

/**
 * @Description: zookeeper 获取子节点数据的demo演示
 */
public class ZKGetChildrenList implements Watcher {
	private static final ZooKeeper ZOOKEEPER = new ZKConnect(ZKConnect.connectString,new ZKGetChildrenList()).getZookeeper();

	private static CountDownLatch countDown = new CountDownLatch(1);
	
	public static void main(String[] args) throws Exception {

		/**
		 * 参数：
		 * path：父节点路径
		 * watch：true或者false，注册一个watch事件
		 */
//		List<String> strChildList = ZOOKEEPER.getChildren("/zk-client", true);
//		for (String s : strChildList) {
//			System.out.println(s);
//		}
		
		// 异步调用
		String ctx = "{'callback':'ChildrenCallback'}";
//		ZOOKEEPER.getChildren("/zk-client", true, new ChildrenCallBack(), ctx);
		ZOOKEEPER.getChildren("/zk-client", true, new Children2CallBack(), ctx);
		
		countDown.await();
	}
	
	@Override
	public void process(WatchedEvent event) {
		try {
			if(event.getType()==EventType.NodeChildrenChanged){
				System.out.println("NodeChildrenChanged");
				List<String> strChildList = ZOOKEEPER.getChildren(event.getPath(), false);
				for (String s : strChildList) {
					System.out.println(s);
				}
				countDown.countDown();
			} else if(event.getType() == EventType.NodeCreated) {
				System.out.println("NodeCreated");
			} else if(event.getType() == EventType.NodeDataChanged) {
				System.out.println("NodeDataChanged");
			} else if(event.getType() == EventType.NodeDeleted) {
				System.out.println("NodeDeleted");
			} 
		} catch (KeeperException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

