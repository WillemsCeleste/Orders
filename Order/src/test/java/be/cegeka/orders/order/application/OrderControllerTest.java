package be.cegeka.orders.order.application;

import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.orders.Itemgroup;
import be.cegeka.orders.order.domain.orders.OrderService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class OrderControllerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderService orderService;

    @Test
    public void addOrder() throws Exception {
       Customer testCustomer = new Customer("Ralphie", "VanCampenHoudt", "ralphie@gmail.com", "diestsestraat 999", "016 320208");

        List<Itemgroup> itemgroup = new ArrayList<>();
        orderController.addOrder(itemgroup,testCustomer);
        verify(orderService).addOrder(itemgroup,testCustomer);

    }

}