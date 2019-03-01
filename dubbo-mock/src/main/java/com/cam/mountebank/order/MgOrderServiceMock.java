package com.cam.mountebank.order;

import java.io.UnsupportedEncodingException;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.JSONObject;
import com.cam.mountebank.order.MgOrderService;
import com.cam.mountebank.order.OrderMsg;
import com.cam.mountebank.order.RequestMsg;

public class MgOrderServiceMock implements MgOrderService
{

	public OrderMsg queryOrderMsg(RequestMsg msg) {
		// TODO Auto-generated method stub
		OrderMsg result = new OrderMsg();
		
		try {
			//result = getMockService(msg);
			result.setOrderNs(msg.getOrderNs()+"mock");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public static OrderMsg getMockService(RequestMsg msg) throws Exception
	{
		OrderMsg result = null;

		String url = "http://localhost:3001";
		HttpClient client = new DefaultHttpClient();
		HttpPost postmethod = new HttpPost(url);
		
		postmethod.setHeader("Content-Type","application/json;charset=UTF-8");
		
		StringBuffer queryParams = new StringBuffer();
		
		queryParams.append("{");
		
		queryParams.append("\"orderNs\":"+"\""+msg.getOrderNs()+"\"");
		
		queryParams.append("}");
		
		String queryJson = queryParams.toString();
		
		System.out.println(queryJson);
		
		StringEntity entity = new StringEntity(queryJson, "utf-8");// 解决中文乱码问题
		entity.setContentEncoding("UTF-8");
		entity.setContentType("application/json");
		
		
		postmethod.setEntity(entity);
		
		HttpResponse reponse = client.execute(postmethod);

		HttpEntity entityR = reponse.getEntity();
		String returnmsg = EntityUtils.toString(entityR, "UTF-8");
		
		System.out.println("result:"+returnmsg);
		
		
		if (returnmsg != null && !returnmsg.isEmpty()) 
		{
			result = JSON.parse(returnmsg, OrderMsg.class);
		}
		
		

		return result;
	}
	
	public static void main(String args[])
	{
		RequestMsg msg = new RequestMsg();
		msg.setOrderNs("2222");
		try {
			getMockService(msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
