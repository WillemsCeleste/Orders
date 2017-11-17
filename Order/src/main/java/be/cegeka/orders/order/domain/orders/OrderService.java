package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.customers.Customer;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Named
public class OrderService {

    @Inject
    private OrderRepository orderRepository;

    public void addOrder(List<Itemgroup> itemgroup, Customer customer) {
        Order orderToAdd = new Order(Date.valueOf(LocalDate.now()), itemgroup);
        orderRepository.addOrder(orderToAdd, customer);
    }
}
