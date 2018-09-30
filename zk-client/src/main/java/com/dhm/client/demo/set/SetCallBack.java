package com.dhm.client.demo.set;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.data.Stat;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/9/30 10:00
 */
public class SetCallBack implements AsyncCallback.StatCallback {
    @Override
    public void processResult(int i, String path, Object ctx, Stat stat) {
        System.out.println("修改节点: " + path);
        System.out.println((String)ctx);
    }
}