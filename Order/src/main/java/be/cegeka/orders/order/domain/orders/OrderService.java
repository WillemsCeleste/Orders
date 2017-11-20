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

    @Inject
    private ItemGroupMapper itemGroupMapper;

    public void addOrder(List<ItemGroupDto> itemGroupDtoList, int customerId) {
        List<ItemGroup> itemGroupList = itemGroupMapper.makeItemGroupList(itemGroupDtoList);
        Order orderToAdd = new Order(Date.valueOf(LocalDate.now()), itemGroupList);
        orderRepository.addOrder(orderToAdd, customerId);
    }

    public List<Order> getOrdersByCustomerId(int customerId) {
        return orderRepository.getOrdersByCustomerId(customerId);
    }
}
