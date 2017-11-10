package be.cegeka.orders.order.domain.items;

import be.cegeka.orders.order.application.ItemController;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class ItemServiceTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private ItemService itemService;

    @Mock
    private ItemRepository itemRepository;

    @Test
    public void addItem_shouldGoToRepository() throws Exception {
        itemService.addItem("Nicky", "Is not really an item, Jerk", new BigDecimal(2.2));
        verify(itemRepository).addItem(new Item("Nicky", "Is not really an item, Jerk", new BigDecimal(2.2)));
    }
}