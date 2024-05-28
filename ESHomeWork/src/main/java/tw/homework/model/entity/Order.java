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
@Table(name =  "order")
public class Order {
	
	@Id
	@Column(name = "order_id")
	private String orderID;
	
	@Column(name = "member_id")
	private Integer memberID;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "paystatus")
	private Integer ayStatus;
}
