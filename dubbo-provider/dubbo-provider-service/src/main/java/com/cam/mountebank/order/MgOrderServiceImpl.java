package com.cam.mountebank.order;

import com.alibaba.dubbo.rpc.RpcContext;
import com.cam.mountebank.order.MgOrderService;
import com.cam.mountebank.order.OrderMsg;
import com.cam.mountebank.order.RequestMsg;

public class MgOrderServiceImpl implements MgOrderService
{

	@Override
	public OrderMsg queryOrderMsg(RequestMsg msg) {
		// TODO Auto-generated method stub
		OrderMsg result = new OrderMsg();
		
		if(msg!=null)
		{
			result.setOrderNs("reality:"+msg.getOrderNs());
		}
		
		RpcContext.getContext().setAttachment("name", "liuwei");
		
		return result;
	}

}
