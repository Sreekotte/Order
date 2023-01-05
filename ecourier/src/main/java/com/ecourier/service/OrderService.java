package com.ecourier.service;


import java.util.List;


import com.ecourier.Exceptions.FillAllTheFieldsException;
import com.ecourier.entity.OrderEntity;



public interface OrderService {
	public OrderEntity placeOrder(OrderEntity placeorder) throws FillAllTheFieldsException ;
	public OrderEntity updateOrder(OrderEntity updateorder);
	public String cancelOrder(long id);
	public List<OrderEntity> viewAllOrders();
	

}
