package tw.homework.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "orderdetail")
public class OrderDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderitemsn")
	private Integer orderItemSN;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "standprice")
	private Integer standPrice;
	
	@Column(name = "itemprice")
	private Integer itemPrice;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Product.class)
	@JoinColumn(name = "product_id", referencedColumnName = "product_id")
	private Product product;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Order.class)
	@JoinColumn(name = "order_id", referencedColumnName = "order_id")
	private Order order;
}
