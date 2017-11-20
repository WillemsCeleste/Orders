package be.cegeka.orders.order.application;

import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.orders.Itemgroup;
import be.cegeka.orders.order.domain.orders.Order;
import be.cegeka.orders.order.domain.orders.OrderService;
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

    @PostMapping
    public void addOrder(List<Itemgroup> itemgroup, Customer customer) {
        orderService.addOrder(itemgroup,customer);
    }

    @GetMapping(path = "/getOrdersByCustomerId")
    public List<Order> getOrdersByCustomerId (@RequestParam (value = "customerId",required = true)int customerId){
        return orderService.getOrdersByCustomerId(customerId);
    }

}
