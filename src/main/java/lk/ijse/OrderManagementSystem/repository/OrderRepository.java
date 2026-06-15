package lk.ijse.OrderManagementSystem.repository;

import lk.ijse.OrderManagementSystem.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query(value = """
    SELECT *
    FROM orders o
    JOIN customer c ON o.customer_customer_id = c.customer_id
    WHERE (?1 IS NULL OR c.customer_name LIKE CONCAT('%', ?1, '%'))
    """, nativeQuery = true)
    List<Order> filterOrders(String customerName);
}