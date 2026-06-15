package lk.ijse.OrderManagementSystem.service;

import lk.ijse.OrderManagementSystem.dto.FilterOrderDTO;
import lk.ijse.OrderManagementSystem.dto.PlaceOrderDTO;
import java.util.List;

public interface OrderService {
    void placeOrder(PlaceOrderDTO  placeOrderDTO);
    List<FilterOrderDTO> filterOrders(String customerName);
}