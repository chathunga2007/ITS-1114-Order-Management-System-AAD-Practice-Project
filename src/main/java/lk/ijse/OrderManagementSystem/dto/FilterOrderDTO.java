package lk.ijse.OrderManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilterOrderDTO {
    private long orderId;
    private String customerName;
    List<ItemDTO> itemList;
}
