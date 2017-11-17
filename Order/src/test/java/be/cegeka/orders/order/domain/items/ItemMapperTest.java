package be.cegeka.orders.order.domain.items;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ItemMapperTest {
    @Test
    public void makeItemFromDto_shouldReturnAnItemWithSameParameters() throws Exception {
        ItemMapper itemMapper = new ItemMapper();
        ItemDto testDto = new ItemDto("Skittles", "Taste the rainbow", BigDecimal.valueOf(299));
        Item actual = itemMapper.makeItemFromDto(testDto);
        Item expected = new Item("Skittles", "Taste the rainbow", BigDecimal.valueOf(299));
        Assertions.assertThat(actual).isEqualTo(expected);
    }


}