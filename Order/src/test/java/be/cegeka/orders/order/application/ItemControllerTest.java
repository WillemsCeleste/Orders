package be.cegeka.orders.order.application;


import be.cegeka.orders.order.domain.items.Item;
import be.cegeka.orders.order.domain.items.ItemService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.math.BigDecimal;

import static org.mockito.Mockito.verify;

public class ItemControllerTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private ItemController itemController;

    @Mock
    private ItemService itemService;

    private Item item;

    @Before
    public void setUp() throws Exception {
        item = new Item("Nicky", "Is not really an item, Jerk", new BigDecimal(2.2));

    }

    @Test
    public void addItem_shouldGoToItemService() throws Exception {
        itemController.addItem(item);
        verify(itemService).addItem(item);
    }
}