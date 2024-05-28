package tw.homework.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.homework.model.entity.Product;



public interface ProductRepository extends JpaRepository<Product, Integer> {

}
