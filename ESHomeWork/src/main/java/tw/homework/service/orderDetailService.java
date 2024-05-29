package tw.homework.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.homework.model.dto.Order.OrderFindDto;
import tw.homework.model.dto.orderDetail.OrderDetailFindcustomerDto;
import tw.homework.model.entity.Order;
import tw.homework.model.entity.OrderDetail;
import tw.homework.model.repository.OrderDetailRepository;

@Service
@Transactional
public class orderDetailService {

	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	
	public List<OrderDetailFindcustomerDto> findAll(){
		
		List<OrderDetail> ordersDetaillList = orderDetailRepository.findAll();
		
		List<OrderDetailFindcustomerDto> oderOrderFindDtolList = new ArrayList<>();
		
		for(OrderDetail orderDetail : ordersDetaillList) {
		
		OrderDetailFindcustomerDto dto = new OrderDetailFindcustomerDto(); 
		
		dto.setOrderId(orderDetail.getOrder().getOrderId());
		dto.setMemberId(orderDetail.getOrder().getMemberId());
		dto.setProductId(orderDetail.getProduct().getProductId());
		dto.setProductName(orderDetail.getProduct().getProductName());
		dto.setQuantity(orderDetail.getQuantity());
		dto.setStandPrice(orderDetail.getStandPrice());
		dto.setItemPrice(orderDetail.getItemPrice());
		
		oderOrderFindDtolList.add(dto);
		
		}	
		return oderOrderFindDtolList;
		
	}
}








