package com.yikangyiliao.base.utils.messageUtil.im;

import com.yikangyiliao.base.utils.messageUtil.MessageUtils;

import cn.jpush.api.push.model.PushPayload;

/**
 * @author liushuaic
 * @date 2015/12/01 15:56
 * @desc 信息发送类
 * 
 * **/
public class MessageSender implements Runnable {

	public void run() {
		while (true){
			
			Message message=MessageQueue.pop();
			PushPayload pushPayload;
			pushPayload=MessageUtils.buildPushObject_all_alias_alert("message_info_165", "---");
			if(null == message){
				try {
					System.out.println(" null ");
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else{
				System.out.println("---"+message.getContent());
				pushPayload=MessageUtils.buildPushObject_all_alias_alert(message.getAlias(), message.getContent());
				
			}
			MessageUtils.sendMessageByPushPayLoad(pushPayload);
		}
	}
	public static void main(String[] args) throws InterruptedException {
				Message m=new Message();
				m.setContent("m");
				
				Message m2=new Message();
				m2.setContent("m2");
				
				Message m3=new Message();
				m3.setContent("m3");
				
				Message m4=new Message();
				m4.setContent("m4");
				
				MessageQueue.put(m);
				MessageQueue.put(m2);
				MessageQueue.put(m3);
				MessageQueue.put(m4);
				
				MessageSender messageSender=new MessageSender();
				new Thread(messageSender).start();
		
	}
	
}
