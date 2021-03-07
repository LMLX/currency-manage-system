package com.lmlx.app.webSocket;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * tianpeiling
 * 2021/1/7 14:21
 */
@Slf4j
@ServerEndpoint(value = "/test/one/{userName}")
@Controller
public class OneWebSocket {
	/** 记录当前在线连接数 */
	private static AtomicInteger onlineCount = new AtomicInteger(0);
	private static ConcurrentHashMap<String, Session> sessionPools = new ConcurrentHashMap<>();
	/**
	 * 连接建立成功调用的方法
	 */
	@OnOpen
	public void onOpen(Session session, @PathParam(value = "userName") String userName) {
//		onlineCount.incrementAndGet(); // 在线数加1
//		log.info("有新连接加入：{}，当前在线人数为：{}", session.getId(), onlineCount.get());
		System.out.println(userName);
		sessionPools.put(userName, session);
		onlineCount.incrementAndGet();
		log.info("有新连接加入：{}，当前在线人数为：{}", userName, onlineCount.get());
		sendMessage( "欢迎" + userName + "加入连接！", session);
	}

	/**
	 * 连接关闭调用的方法
	 */
	@OnClose
	public void onClose(Session session) {
		onlineCount.decrementAndGet(); // 在线数减1
		log.info("有一连接关闭：{}，当前在线人数为：{}", session.getId(), onlineCount.get());
	}

	/**
	 * 收到客户端消息后调用的方法
	 *
	 * @param message
	 *            客户端发送过来的消息
	 */
	@OnMessage
	public void onMessage(String message, Session session) {
		log.info("服务端收到客户端[{}]的消息:{}", session.getId(), message);
		System.out.println();
		this.sendMessage( message, session);
	}

	@OnError
	public void onError(Session session, Throwable error) {
		log.error("发生错误");
		error.printStackTrace();
	}

	/**
	 * 服务端发送消息给客户端
	 */
	private void sendMessage(String message, Session toSession) {
		try {
//			log.info("服务端给客户端[{}]发送消息{}", toSession.getId(), message);
			toSession.getBasicRemote().sendText(message);
		} catch (Exception e) {
			log.error("服务端发送消息给客户端失败：{}", e);
		}
	}

	public void send(String userName, String message) {
		Session toSession = sessionPools.get(userName);
		if(null !=toSession)  {
			sendMessage(message, toSession);
		}

	}
}
