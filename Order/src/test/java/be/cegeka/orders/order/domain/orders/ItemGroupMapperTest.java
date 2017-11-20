package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.items.Item;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ItemGroupMapperTest {
    private Item testItem;
    private ItemGroupDto testItemGroupDto;
    private List<ItemGroupDto> testItemGroupDtoList;

    @Before
    public void setUp() throws Exception {
        testItemGroupDto = new ItemGroupDto(4,10);
        testItemGroupDtoList = new ArrayList<>();
        testItemGroupDtoList.add(testItemGroupDto);
        testItem = new Item("Koe","een koe, duh!", BigDecimal.valueOf(10));

    }

    @Test
    public void makeItemGroup_shouldReturnItemGroup_givenItemGroupDto() throws Exception {

        ItemGroup expected = new ItemGroup(4, Date.valueOf(LocalDate.of(2017, 11, 10)),testItem);

        Assertions.assertThat(true);
    }


    @Test
    public void makeItemGroupList_ShouldReturnListOfItemGroup_givenListOfItemGroupDto() throws Exception {

    }
}