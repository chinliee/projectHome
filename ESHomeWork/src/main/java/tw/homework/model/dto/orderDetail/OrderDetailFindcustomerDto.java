package tw.homework.model.dto.orderDetail;

import lombok.Data;

@Data
public class OrderDetailFindcustomerDto {

	private String orderId;
	
	private Integer memberId;
	
	private String productId;
	
	private String productName;
	
	private Integer quantity;
	
	private Integer itemPrice;
	
	private Integer standPrice;
}
