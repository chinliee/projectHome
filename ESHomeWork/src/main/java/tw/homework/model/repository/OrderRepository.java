package tw.homework.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.homework.model.entity.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order,String > {

	boolean existsByOrderId(String orderId);
}
