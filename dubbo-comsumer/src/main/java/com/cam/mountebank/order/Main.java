package com.cam.mountebank.order;

import java.util.Scanner;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.rpc.RpcContext;


public class Main {
	
	public static void main(String args[])
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/*.xml");
		
		MgOrderService service = (MgOrderService) context.getBean("mgOrderService");
		
		//System.out.println(getProcessID());
		
		while (true) 
		{
			Scanner sc = new Scanner(System.in);
			
			String ns = sc.nextLine();

			RequestMsg msg = new RequestMsg();

			msg.setOrderNs(ns);
			
			OrderMsg result = null;

			try {
				RpcContext.getContext().setAttachment("name", "liuwei");
				result = service.queryOrderMsg(msg);
				
				System.out.println(RpcContext.getContext().getAttachment("name"));
				
			} catch (Exception e) {

			}

			System.out.println(result != null ? result.getOrderNs() : "empty");
		}
	}
	
	public static final int getProcessID() {
		RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
		System.out.println(runtimeMXBean.getName());
		return Integer.valueOf(runtimeMXBean.getName().split("@")[0]).intValue();
	}


}
