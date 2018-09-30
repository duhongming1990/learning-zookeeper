package com.dhm.client.demo.create;


import org.apache.zookeeper.AsyncCallback.StringCallback;
/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/9/30 9:34
 */
public class CreateCallBack implements StringCallback {

	@Override
	public void processResult(int rc, String path, Object ctx, String name) {
		System.out.println("创建节点: " + path);
		System.out.println((String)ctx);
	}

}
