package tw.homework.model.dto.product;

import lombok.Data;

@Data
public class ProductFindDto {

	private String productId;
		
	private String productName;
		
	private Integer price;
	
	private Integer quantity;
}
