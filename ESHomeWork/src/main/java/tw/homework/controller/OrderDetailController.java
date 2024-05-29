package tw.homework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.homework.model.dto.orderDetail.OrderDetailFindcustomerDto;
import tw.homework.model.entity.OrderDetail;
import tw.homework.service.orderDetailService;

@RestController
public class OrderDetailController {

	@Autowired
	private orderDetailService orderDetailService;
	
	@PostMapping("/orderDetail")
	public List<OrderDetailFindcustomerDto> findAllCustomer(){
		
		return orderDetailService.findAll();
		
	}
	
	
}
