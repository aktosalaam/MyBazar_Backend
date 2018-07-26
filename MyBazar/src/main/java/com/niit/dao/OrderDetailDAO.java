package com.niit.dao;

import com.niit.model.OrderDetail;

public interface OrderDetailDAO
{
	public boolean receiptGenerate(OrderDetail orderDetail);
	public boolean updateCartItemStatus(String username);
}
