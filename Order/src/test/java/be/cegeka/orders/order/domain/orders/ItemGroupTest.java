package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.items.Item;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

public class ItemGroupTest {

    private ItemGroup testItemGroup;
    private Item koe;
    private Item koe2;
    private ItemGroup testItemGroup2;

    @Before
    public void name() throws Exception {
        koe = new Item ("koe", "big and loud", BigDecimal.valueOf(5.00));
        koe2 = new Item ("koe", "big and loud", BigDecimal.valueOf(5.00));
        testItemGroup = new ItemGroup(5,koe);
        ReflectionTestUtils.setField(testItemGroup,"iooId",21);
        testItemGroup2 = new ItemGroup(5, koe2);
        ReflectionTestUtils.setField(testItemGroup2,"iooId",7);
    }

    @Test
    public void getItemgroupPrice() throws Exception {
        Assertions.assertThat(testItemGroup.getItemgroupPrice()).isEqualTo(BigDecimal.valueOf(25.0));

    }

    @Test
    public void getItem() throws Exception {

        Assertions.assertThat(testItemGroup.getItem()).isEqualTo(koe);
    }

    @Test
    public void equals_sameObject_isTrue() throws Exception {
        Assertions.assertThat(testItemGroup).isEqualTo(testItemGroup);
    }

    @Test
    public void equals_differentId_isFalse() throws Exception {
        Assertions.assertThat(testItemGroup).isNotEqualTo(testItemGroup2);
    }

     @Test
    public void equals_nullObject_isFalse() throws Exception {
        Assertions.assertThat(testItemGroup).isNotEqualTo(null);
    }

     @Test
    public void equals_otherClass_isFalse() throws Exception {
        Assertions.assertThat(testItemGroup).isNotEqualTo(new Object());
    }



}