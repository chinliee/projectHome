package tw.homework.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class OrderDetail {
	
	@Id
	@Column(name = "orderitemsn")
	private Integer orderItemSN;
	
	@Column(name = "order_id")
	private String orderID;
	
	@Column(name = "product_id")
	private String productID;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "standprice")
	private Integer standPrice;
	
	@Column(name = "itemprice")
	private Integer itemPrice;
}
