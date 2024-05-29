package tw.homework.model.dto.Order;

import java.util.List;

import lombok.Data;

@Data
public class OrderCreateDto {

	 private Integer memberId;
	 
	 private List<OrderProductDto> orderProductDtoliList;
	
	
	 
	 
}
