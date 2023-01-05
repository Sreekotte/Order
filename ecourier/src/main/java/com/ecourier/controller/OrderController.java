package com.ecourier.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecourier.Exceptions.FillAllTheFieldsException;
import com.ecourier.entity.OrderEntity;
import com.ecourier.service.OrderService;


@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderservice;
	
	
	 @PostMapping("/place")
     public OrderEntity placeOrder(@RequestBody OrderEntity placeorder) throws FillAllTheFieldsException {
           
  	   OrderEntity place =this.orderservice.placeOrder(placeorder);
           return place;
           
     }
	 
	 @PutMapping("/update")
     public OrderEntity updateOrder(@RequestBody OrderEntity updateorder) {
           
  	   OrderEntity update =this.orderservice.updateOrder(updateorder);
           return update;
	 }
	 
	 @DeleteMapping("/cancel/{id}")
	 public String cancelOrder(@PathVariable ("id") long id) {
         
         String cancel = this.orderservice.cancelOrder(id);
         return cancel;
   }
	 
	 
     @GetMapping("/get")
     public List<OrderEntity> viewAllOrders(){
           
     List<OrderEntity> allorders =this.orderservice.viewAllOrders();
           return allorders;
           
     }
	 
	

}
