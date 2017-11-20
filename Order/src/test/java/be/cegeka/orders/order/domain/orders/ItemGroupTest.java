package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.items.Item;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

public class ItemGroupTest {

    private ItemGroup testItemGroup;
    private Item koe;
    @Before
    public void name() throws Exception {
        koe = new Item ("koe", "big and loud", BigDecimal.valueOf(5.00));
        testItemGroup = new ItemGroup(5, Date.valueOf(LocalDate.of(2017, 11, 10)),koe);
    }

    @Test
    public void getItemgroupPrice() throws Exception {
        Assertions.assertThat(testItemGroup.getItemgroupPrice()).isEqualTo(BigDecimal.valueOf(25.0));

    }

    @Test
    public void getItem() throws Exception {

        Assertions.assertThat(testItemGroup.getItem()).isEqualTo(koe);
    }
}