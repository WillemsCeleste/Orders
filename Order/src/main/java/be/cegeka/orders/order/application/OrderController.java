package be.cegeka.orders.order.application;

import be.cegeka.orders.order.domain.orders.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.transaction.Transactional;

@RestController
@RequestMapping(path = "/order")
@Transactional
public class OrderController {

    @Inject
    private OrderService orderService;

    @PostMapping
    public void addOrder() {
        orderService.addOrder();
    }

}
