package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.items.Item;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class OrderTest {


    private Order order, order2;

    private List<ItemGroup> itemGroup;

    @Before
    public void setUp() throws Exception {
        Customer testCustomer = new Customer("Ralphie", "VanCampenHoudt", "ralphie@gmail.com", "diestsestraat 999", "016 320208");
        Date date = Date.valueOf(LocalDate.of(2017, 11, 10));
        Date shippingDate = Date.valueOf(LocalDate.of(2017, 11, 13));
        Item konijn = new Item("konijn", "cute and fluffy", BigDecimal.valueOf(2.00));
        Item koe = new Item ("koe", "big and loud", BigDecimal.valueOf(5.00));
        ItemGroup item1 = new ItemGroup(5, shippingDate, konijn);
        ItemGroup item2 = new ItemGroup(3, shippingDate, koe);
        itemGroup = new ArrayList<>();
        itemGroup.add(item1);
        itemGroup.add(item2);
        order = new Order(date, itemGroup);
        order2 = new Order(date, itemGroup);
    }

    @Test
    public void getTotalPrice() throws Exception {
        assertThat(order.getTotalPrice(itemGroup)).isEqualTo(BigDecimal.valueOf(25.0));
    }

    @Test
    public void anOrder_shouldNotEqualADifferentObject() throws Exception {
        Order actual = order;
        Object expected = new Object();
        Assertions.assertThat(actual).isNotEqualTo(expected);
    }

    @Test
    public void anOrder_shouldEqualItself() throws Exception {
        Assertions.assertThat(order).isEqualTo(order);
    }

    @Test
    public void anOrder_equalsNullObject_shouldBeFalse() throws Exception {
        Assertions.assertThat(order).isNotEqualTo(null);
    }

    @Test
    public void anOrderWithADifferentId_shouldNotBeEqual() throws Exception {
        ReflectionTestUtils.setField(order2, "orderId", 5);
        Assertions.assertThat(order).isNotEqualTo(order2);
    }
}