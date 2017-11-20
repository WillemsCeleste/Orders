package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.items.Item;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OrderServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private OrderService orderService;

    @Mock
    private ItemGroupMapper itemGroupMapper;

    @Mock
    private OrderRepository orderRepository;


    @Test
    public void addOrder() throws Exception {
        Item swedishPenisPump = new Item("Swedish Penis Pump", "Pumping da noodle", new BigDecimal(299));
        List<ItemGroupDto> itemGroupDtoList = new ArrayList<>();
        when(itemGroupMapper.makeItemGroupList(itemGroupDtoList)).thenReturn(new ArrayList<ItemGroup>());
        ItemGroupDto testIGD = new ItemGroupDto(5,swedishPenisPump.getId());
        itemGroupDtoList.add(testIGD);
        List<ItemGroup> itemGroupList = itemGroupMapper.makeItemGroupList(itemGroupDtoList);
        orderService.addOrder(itemGroupDtoList, 1);
        verify(orderRepository).addOrder(Mockito.refEq(new Order(Date.valueOf(LocalDate.now()), itemGroupList)),Mockito.eq(1));
    }
}