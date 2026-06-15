package lk.ijse.OrderManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlaceOrderDTO {
    private long customerId;
    private double total;
    private List<Long> itemIdList;
}