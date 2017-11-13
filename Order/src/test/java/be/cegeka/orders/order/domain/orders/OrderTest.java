package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.items.Item;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class OrderTest {


    private Order order;

    @Before
    public void setUp() throws Exception {
        Customer testCustomer = new Customer("Ralphie", "VanCampenHoudt", "ralphie@gmail.com", "diestsestraat 999", "016 320208");
        Date date = Date.valueOf(LocalDate.of(2017, 11, 10));
        Date shippingDate = Date.valueOf(LocalDate.of(2017, 11, 13));
        Item konijn = new Item("konijn", "cute and fluffy", BigDecimal.valueOf(2.00));
        Item koe = new Item ("koe", "big and loud", BigDecimal.valueOf(5.00));
        Itemgroup item1 = new Itemgroup(5, shippingDate, konijn);
        Itemgroup item2 = new Itemgroup(3, shippingDate, koe);
        List<Itemgroup> itemgroup = new ArrayList<>();
        itemgroup.add(item1);
        itemgroup.add(item2);
        order = new Order(date, itemgroup);
    }

    @Test
    public void getTotalPrice() throws Exception {
        assertThat(order.getTotalPrice()).isEqualTo(BigDecimal.valueOf(25.0));
    }

    @Test
    public void equals() throws Exception {
    }

}