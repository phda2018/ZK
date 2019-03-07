package com.phda.util;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZkOperateUtil {

	private ZooKeeper zk;
	
	public ZkOperateUtil() {
		this.zk = new ZkConnect().connect();
	}
	/**
	 * 创建节点
	 * 
	 * */
	public boolean CreateNode(String path,String data) {
		boolean res =true ;
		try {
			zk.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT );
		} catch (KeeperException e) {
			res = false;
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			res = false;
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * 获取znode 数据
	 */
	public void getData() {
		try {
			System.out.println("run getData");
			byte[] znodeData = zk.getData("/phdaNode", new Watcher() {
				@Override
				public void process(WatchedEvent event) {
					// TODO Auto-generated method stub
					KeeperState ks= event.getState();
					System.out.println("获取数据，回调函数:"+event.getType());
				}
				
			}, new Stat());
			
			System.out.println("获取数据:"+new String(znodeData));
			
		} catch (KeeperException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void findNode() {
		//zk.getData(path, watch, stat);
		//zk.exists(path, watch)
	}	
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("runnig");
		ZkOperateUtil zkCon = new ZkOperateUtil();
		//zk.CreateNode("/phdaNode1", "phdaNode");
		zkCon.getData();
		Thread.sleep(20*1000);
		
	}

}
