package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.items.Item;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.util.ReflectionTestUtils;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ItemGroupMapperTest {
    private Item testItem;
    private ItemGroupDto testItemGroupDto;
    private List<ItemGroupDto> testItemGroupDtoList;
    private ItemGroup testItemGroup;


    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private ItemGroupMapper testMapper;

    @Mock
    private OrderRepository orderRepository;


    @Before
    public void setUp() throws Exception {
        testItemGroupDto = new ItemGroupDto(4,10);
        testItemGroupDtoList = new ArrayList<>();
        testItemGroupDtoList.add(testItemGroupDto);
        testItem = new Item("Koe","een koe, duh!", BigDecimal.valueOf(10));
        ReflectionTestUtils.setField(testItem,"id",10);
        testItemGroup = new ItemGroup(4,testItem);
        when(orderRepository.getItemByID(testItemGroupDto.itemId)).thenReturn(testItem);

    }

    @Test
    public void makeItemGroup_shouldReturnItemGroup_givenItemGroupDto() throws Exception {

        ItemGroup actual = testMapper.makeItemGroup(testItemGroupDto);
        ItemGroup expected = testItemGroup;

        Assertions.assertThat(actual).isEqualTo(expected);
    }


    @Test
    public void makeItemGroupList_ShouldReturnListOfItemGroup_givenListOfItemGroupDto() throws Exception {

        List<ItemGroup> actual = testMapper.makeItemGroupList(testItemGroupDtoList);
        List<ItemGroup> expected = new ArrayList<>();
        expected.add(testItemGroup);

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}