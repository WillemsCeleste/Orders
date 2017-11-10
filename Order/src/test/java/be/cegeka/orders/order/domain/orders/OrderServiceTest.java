package be.cegeka.orders.order.domain.orders;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class OrderServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Test
    public void addOrder() throws Exception {
        orderService.addOrder();

        verify(orderRepository).addOrder();
    }
}