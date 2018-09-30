package com.dhm.client.demo.get;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import com.dhm.client.demo.connection.ZKConnect;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * 
 * @Description: zookeeper 获取节点数据的demo演示
 */
public class ZKGetNodeData implements Watcher {
	private static final ZooKeeper ZOOKEEPER = new ZKConnect(ZKConnect.connectString,new ZKGetNodeData()).getZookeeper();

	private static Stat stat = new Stat();
	
	private static CountDownLatch countDown = new CountDownLatch(1);
	
	public static void main(String[] args) throws Exception {
		
		/**
		 * 参数：
		 * path：节点路径
		 * watch：true或者false，注册一个watch事件
		 * stat：状态
		 */
		byte[] resByte = ZOOKEEPER.getData("/zk-client", true, stat);
		String result = new String(resByte);
		System.out.println("当前值:" + result);
		countDown.await();
	}
	
	@Override
	public void process(WatchedEvent event) {
		try {
			if(event.getType() == EventType.NodeDataChanged){
				byte[] resByte = ZOOKEEPER.getData("/zk-client", false, stat);
				String result = new String(resByte);
				System.out.println("更改后的值:" + result);
				System.out.println("版本号变化dversion：" + stat.getVersion());
				countDown.countDown();
			} else if(event.getType() == EventType.NodeCreated) {
				
			} else if(event.getType() == EventType.NodeChildrenChanged) {
				
			} else if(event.getType() == EventType.NodeDeleted) {
				
			} 
		} catch (KeeperException e) { 
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

