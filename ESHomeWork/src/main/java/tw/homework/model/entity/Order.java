package tw.homework.model.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name =  "[order]")
public class Order {
	
	@Id
	@Column(name = "order_id")
	private String orderId;
	
	@Column(name = "member_id")
	private Integer memberId;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "paystatus")
	private Integer payStatus;
	
	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = {CascadeType.ALL},orphanRemoval = true, targetEntity = OrderDetail.class)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<OrderDetail> orderDetaillList = new ArrayList<>();
	
}
