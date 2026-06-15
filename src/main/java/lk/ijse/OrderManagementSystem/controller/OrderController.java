package lk.ijse.OrderManagementSystem.controller;

import lk.ijse.OrderManagementSystem.constant.CommonResponse;
import lk.ijse.OrderManagementSystem.dto.FilterOrderDTO;
import lk.ijse.OrderManagementSystem.dto.PlaceOrderDTO;
import lk.ijse.OrderManagementSystem.service.OrderService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static lk.ijse.OrderManagementSystem.constant.ResponseMessage.SUCCESS_MESSAGE;
import static lk.ijse.OrderManagementSystem.constant.ResponseStatusCode.OPERATION_SUCCESS;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse placeOrder(@RequestBody PlaceOrderDTO placeOrderDTO) {
        orderService.placeOrder(placeOrderDTO);
        return new CommonResponse(OPERATION_SUCCESS, SUCCESS_MESSAGE);
    }

    @GetMapping(value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse filterOrders(@RequestParam(value = "customerName", required = false) String customerName) {
        List<FilterOrderDTO> filterOrderDTOList = orderService.filterOrders(customerName);
        return new CommonResponse(OPERATION_SUCCESS, filterOrderDTOList, SUCCESS_MESSAGE);
    }
}