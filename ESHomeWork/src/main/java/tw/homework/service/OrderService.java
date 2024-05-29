package tw.homework.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import tw.homework.model.dto.Order.OrderCreateDto;
import tw.homework.model.dto.Order.OrderFindDto;
import tw.homework.model.dto.Order.OrderProductDto;
import tw.homework.model.entity.Order;
import tw.homework.model.entity.OrderDetail;
import tw.homework.model.entity.Product;
import tw.homework.model.repository.OrderDetailRepository;
import tw.homework.model.repository.OrderRepository;
import tw.homework.model.repository.ProductRepository;

@Service
@Transactional
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<OrderFindDto> findAll(){
		
		List<Order> orderslList = orderRepository.findAll();
		
		List<OrderFindDto> oderOrderFindDtolList = new ArrayList<>();
		
		for(Order order : orderslList) {
		
		OrderFindDto orderFindDto = new OrderFindDto(); 
		
		orderFindDto.setOrderId(order.getOrderId());
		orderFindDto.setMemberId(order.getMemberId());
		orderFindDto.setPrice(order.getPrice());
		orderFindDto.setPayStatus(order.getPayStatus());
		
		oderOrderFindDtolList.add(orderFindDto);
		
		}	
		return oderOrderFindDtolList;
		
	}
	
	public boolean createOrder(OrderCreateDto dto) {
		
		List<OrderProductDto> orderProductDtoList = dto.getOrderProductDtoliList();
		
        List<Product> productUpdate = new ArrayList<>();

        for(OrderProductDto orderProductDto:orderProductDtoList) {
        	
        	Product product = productRepository.findByProductId(orderProductDto.getProductId());
//        	不為負以及大於庫存量
        	if(product.getQuantity() < orderProductDto.getQuantity() || orderProductDto.getQuantity() < 1) {
        		return false;
        	}
        	productUpdate.add(product);
        	
        }
		
        String orderId = checkOrderId();
        
        Order order = new Order();
        order.setOrderId(orderId);
        order.setMemberId(dto.getMemberId());
        order.setPrice(calculateTotalPrice(orderProductDtoList));    
        // 默認未付款
        order.setPayStatus(0); 
        orderRepository.save(order);
        
        
       for(OrderProductDto productDto:orderProductDtoList) {
    	   
    	   Product product = productRepository.findByProductId(productDto.getProductId());
    	   
    	   OrderDetail orderDetail = new OrderDetail();
    	   
    	   orderDetail.setOrder(order);
    	   orderDetail.setProduct(product);
           orderDetail.setQuantity(productDto.getQuantity());
           orderDetail.setStandPrice(product.getPrice());
           orderDetail.setItemPrice(product.getPrice() * productDto.getQuantity());
           orderDetailRepository.save(orderDetail);

           // 更新庫存
           product.setQuantity(product.getQuantity() - productDto.getQuantity());
    	   
    	   
       }
        
       for (Product product : productUpdate) {
           productRepository.save(product);
       }

       return true;
   }
	
        
       private String getUUId() {
    	   
    	   String getDate = LocalDate.now().format(DateTimeFormatter.ofPattern("YYYYMMdd"));
    	   
    	   String uuid = UUID.randomUUID().toString().replaceAll("[^0-9]", "").substring(0,6);
    	   
    	   return "Ms" + getDate + uuid;
       }
        
       private Integer calculateTotalPrice(List<OrderProductDto> dto) {
           int total = 0;
           for (OrderProductDto orderProductDto : dto) {
               
        	   Product product = productRepository.findByProductId(orderProductDto.getProductId());
              
        	   total += product.getPrice() * orderProductDto.getQuantity();
           }
           return total;
       }
//      檢查資料庫是否Id重複
       private String checkOrderId() {
    	   String orderId;
    	   
    	   do {
    		   orderId =getUUId();
    	   }while(orderRepository.existsByOrderId(orderId)); {
    		   return orderId;
    	   }   	   
       }
	}
	
	
	
	
		
	
	

