package tw.homework.model.dto.Order;

import lombok.Data;

@Data
public class OrderFindDto {

	private String orderId;
	
	private Integer memberId;
	
	private Integer price;
	
	private Integer payStatus;
}
