package com.cam.mountebank.order;

import java.io.Serializable;

public class OrderMsg implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String orderNs;
	
	private String orderName;
	
	private String desc;

	public String getOrderNs() {
		return orderNs;
	}

	public void setOrderNs(String orderNs) {
		this.orderNs = orderNs;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
