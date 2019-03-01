package com.cam.mountebank.order;

import com.cam.mountebank.order.MgOrderService;
import com.cam.mountebank.order.OrderMsg;
import com.cam.mountebank.order.RequestMsg;

public class MgOrderServiceStub implements MgOrderService
{
	public MgOrderServiceStub(MgOrderService mgOrderService)
	{
		
	}

	public OrderMsg queryOrderMsg(RequestMsg msg) {
		// TODO Auto-generated method stub
		OrderMsg result = new OrderMsg();
		
		try {
			//result = getMockService(msg);
			result.setOrderNs(msg.getOrderNs()+"stub");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	

}
