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
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "product" )
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name =	"product_id" )
	private String productId;
	
	@Column(name = "product_name" )
	private String productName;
	
	@Column(name = "price" )
	private Integer price;
	
	@Column(name = "quantity" )
	private Integer quantity;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = {CascadeType.ALL},orphanRemoval = true, targetEntity = OrderDetail.class)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonIgnore
	private List<OrderDetail> orderDetaillList = new ArrayList<>();
	
}
