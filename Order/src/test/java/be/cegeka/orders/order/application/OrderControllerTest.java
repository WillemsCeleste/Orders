package be.cegeka.orders.order.application;

import be.cegeka.orders.order.domain.orders.OrderService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

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
        orderController.addOrder();

        verify(orderService).addOrder();

    }

}