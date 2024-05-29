package tw.homework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.homework.model.dto.Order.OrderCreateDto;
import tw.homework.model.dto.Order.OrderFindDto;
import tw.homework.service.OrderService;



@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/order/find")
	public List<OrderFindDto> findAll(){
		
		return orderService.findAll();
	}
	
	  @PostMapping("/create")
	    public ResponseEntity<String> createOrder(@RequestBody OrderCreateDto orderCreateDto) {
	       
		  boolean success = orderService.createOrder(orderCreateDto);
	        
		  if (success) {
	            return ResponseEntity.ok("Order created successfully!");
	        } else {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create order, insufficient stock");
	        }
	    }
	
}
