package com.cam.mountebank.order;

import java.io.Serializable;

public class RequestMsg implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String orderNs;

	public String getOrderNs() {
		return orderNs;
	}

	public void setOrderNs(String orderNs) {
		this.orderNs = orderNs;
	}

}
