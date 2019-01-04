package com.phda.util;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

/**
 * 连接操作zookeeper 类
 * @author phda
 *
 */
public class ZkConnect {
	CountDownLatch c = new CountDownLatch(1);
	
	
	public ZkConnect() {
		// TODO Auto-generated constructor stub
	}
	
	public ZooKeeper connect() {
		try {
			ZooKeeper zk = new ZooKeeper("172.20.0.202:2181", 1000*10, new watcherUtil( this.c ));
			System.out.println("等待zookeeper连接");
			c.await();
			return zk;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		
		ZkConnect zk = new ZkConnect();
		zk.connect();//建立zookeeper 连接
		
		try {
			Thread.sleep(10*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**要校验连接状态
	 * @author phda
	 */
	class watcherUtil implements Watcher {
		private CountDownLatch countDonw;
		public watcherUtil( CountDownLatch countDonw ) {
			this.countDonw = countDonw;
		}
		
		@Override
		public void process(WatchedEvent event) {
			
			String path = event.getPath();
			int value = event.getType().getIntValue();
			System.out.print(path+" "+value+" "+event.getState());
			
			if(event.getState() == KeeperState.SyncConnected) {
				System.out.println("zookeeper 连接了");
				this.countDonw.countDown();
			}
			
			
		}
	}

	
	
	

}
