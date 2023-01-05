package com.ecourier.service.Impl;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ecourier.Exceptions.FillAllTheFieldsException;
import com.ecourier.entity.OrderEntity;
import com.ecourier.repository.OrderRepository;
import com.ecourier.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepo;

	@Override
	public OrderEntity placeOrder(OrderEntity placeorder) throws FillAllTheFieldsException {
		if(placeorder.getAddress()==null || placeorder.getAmount()== 0 || placeorder.getFromLocation()==null||
				placeorder.getFromPinCode()==0 || placeorder.getMobileNo()== 0 || placeorder.getName()==null||
				placeorder.getToLocation()==null|| placeorder.getToPinCode()==0) {
			throw new FillAllTheFieldsException("Fill All The Fields");
		}else 
	 return this.orderRepo.save(placeorder);
		
	}

	@Override
	public OrderEntity updateOrder(OrderEntity updateorder) {
		return this.orderRepo.save(updateorder);
		//return this.orderRepo.findById(updateorder.getTrackingNumber()).get();
	}

	@Override
	public String cancelOrder(long id) {
		this.orderRepo.deleteById(id);
		return "Order has been Cancelled";
	}
	
	@Override
	public List<OrderEntity> viewAllOrders() {
		List<OrderEntity> list = this.orderRepo.findAll();
		return list;
	}

	
	


}
