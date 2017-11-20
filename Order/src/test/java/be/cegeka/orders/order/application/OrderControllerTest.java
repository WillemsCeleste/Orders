package be.cegeka.orders.order.application;

import be.cegeka.orders.order.domain.orders.ItemGroupDto;
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
        List<ItemGroupDto> itemGroupDtoList = new ArrayList<>();
        orderController.addOrder(itemGroupDtoList,1);
        verify(orderService).addOrder(itemGroupDtoList, 1);

    }

    @Test
    public void getOrdersByCustomerId_shouldActivateOrderServiceMethod() throws Exception {
        orderController.getOrdersByCustomerId(1);
        verify(orderService).getOrdersByCustomerId(1);
    }
}