package com.phda.util;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.client.ZooKeeperSaslClient;

public class ZkOperateUtil {

	private ZooKeeper zk;
	
	public ZkOperateUtil() {
		this.zk = new ZkConnect().connect();
	}
	
	
	/**创建节点
	 * */
	public void CreateNode(String path,String data) {
		System.out.print("创建节点");
		try {
			zk.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT );
		} catch (KeeperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("runnig");
		
		
		
		ZkOperateUtil zk = new ZkOperateUtil();
		zk.CreateNode("/phdaNode", "phdaNode");
		

	}

}
