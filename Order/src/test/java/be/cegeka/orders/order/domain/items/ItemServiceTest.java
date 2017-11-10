package be.cegeka.orders.order.domain.items;

import be.cegeka.orders.order.application.ItemController;
import be.cegeka.orders.order.application.ItemDto;
import org.junit.Before;
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
    @Mock
    private ItemMapper itemMapper;

    private ItemDto itemDto;

    @Before
    public void setUp() throws Exception {
        itemDto = new ItemDto("Nicky", "Is not really an item, Jerk", new BigDecimal(2.2));

    }
    @Test
    public void addItem_shouldGoToRepository() throws Exception {
        itemService.addItem(itemDto);
        verify(itemRepository).addItem(itemMapper.makeItemFromDto(itemDto));
    }
}