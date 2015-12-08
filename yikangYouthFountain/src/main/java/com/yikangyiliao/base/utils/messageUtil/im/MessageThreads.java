package com.yikangyiliao.base.utils.messageUtil.im;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * 
 * @author liushuaic
 * @date 2015/12/01 18:30
 * @desc 添加发送信息线程池
 * 
 * **/
public class MessageThreads {
	
	private static MessageSender messageSender;
	
	static{
		messageSender=new MessageSender();
	}
	
	public void startSendMessage(){
		ThreadPoolExecutor threadPoolExecutor=
				new ThreadPoolExecutor(12, 20, 3000, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(3));
		threadPoolExecutor.execute(messageSender);
	}

	public static void main(String[] args) throws InterruptedException {
//		message_info_165
		Message message=new Message();
		message.setAlias("message_info_165");
		message.setContent("test");
		MessageThreads messageThreads=new MessageThreads();
		messageThreads.startSendMessage();
		MessageQueue.put(message);
		
	}
	
}
