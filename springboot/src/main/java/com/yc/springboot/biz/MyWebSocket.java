package com.yc.springboot.biz;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@ServerEndpoint(value = "/websocket/{id}")
@Component
public class MyWebSocket {

	//hashtable 用来存放每个客户端对应的id：Session对象
	private  static Hashtable<String, Session> webSocketMap=new Hashtable<String, Session>();
	
	//连接建立成功调用得方法
	@OnOpen
	public void onOpen(@PathParam("id") String id,Session session) {
		//HashMap线程不安全，hashtable线程安全
		System.out.println(id+"已连接");
		webSocketMap.put(id, session);
	}
	
	//连接关闭调用的方法、
	@OnClose
	public void onClose(Session session) {
		//移除webSocketMap中的会话
		 for (Map.Entry<String, Session> entry : webSocketMap.entrySet()) {
	            if(entry.getValue()==session) {
	            	entry.setValue(null);
	            }
	        }
	}
	
	@OnMessage
	public void onMessage(String message,Session session) throws IOException {
		
		String[] ss=message.split(":");
		String id=ss[0];
		String msg=ss[1];
		Session targetSession=webSocketMap.get(id);
		if(targetSession!=null) {
			
			System.out.println(msg);
		}else {
			System.err.println(id+"不在线");
		}
	}
	
	//每2分钟执行一次
	@Scheduled(cron="0 */2 * * * ?")
	public void loveyou() throws IOException {
		for(Session session:webSocketMap.values()) {
			session.getBasicRemote().sendText("猪猪我真的想你啊");
		}
	}
	
}
