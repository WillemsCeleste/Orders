package be.cegeka.orders.order.application;


import be.cegeka.orders.order.domain.orders.ItemGroupDto;
import be.cegeka.orders.order.domain.orders.Order;
import be.cegeka.orders.order.domain.orders.OrderService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/order")
@Transactional
public class OrderController {

    @Inject
    private OrderService orderService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addOrder(@RequestBody List<ItemGroupDto> itemGroupDtoList, @RequestParam(value = "customer_id", required = true) int customerID) {
        orderService.addOrder(itemGroupDtoList,customerID);
    }

    @GetMapping(path = "/getOrdersByCustomerId")
    public List<Order> getOrdersByCustomerId (@RequestParam (value = "customerId",required = true)int customerId){
        return orderService.getOrdersByCustomerId(customerId);
    }

}
