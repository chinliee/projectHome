package tw.homework.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.homework.model.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	
	Product findByProductId(String productId);
	
}
