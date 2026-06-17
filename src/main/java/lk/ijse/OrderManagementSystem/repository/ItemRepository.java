package lk.ijse.OrderManagementSystem.repository;

import lk.ijse.OrderManagementSystem.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
    @Query(value = """
    SELECT *
    FROM item i
    WHERE (?1 IS NULL OR i.item_name LIKE CONCAT('%', ?1, '%'))
    """, nativeQuery = true)
    List<Item> filterItems(String itemName);
}