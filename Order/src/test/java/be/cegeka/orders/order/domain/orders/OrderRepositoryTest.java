package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.OrderApplication;
import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.items.Item;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = OrderApplication.class)
@Transactional
public class OrderRepositoryTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private OrderRepository orderRepository;

    @Test
    public void addOrder_shouldAddAnOrderToDatabase() throws Exception {
        Customer customer = new Customer("name", "noname", "blabla@gmail.com", "nope", "ringringbanaphone");
        entityManager.persist(customer);

//        Item swedishPenisPump = new Item("Swedish Penis Pump", "Pumping da noodle", new BigDecimal(299));
//        entityManager.persist(swedishPenisPump);

//        List<ItemGroupDto> itemGroupDtoList = new ArrayList<>();
//        ItemGroupDto testIGD = new ItemGroupDto(5,swedishPenisPump.getId());
//        itemGroupDtoList.add(testIGD);
        Order order = new Order(new Date(2017 - 10 - 15),
                Arrays.asList(new ItemGroup(1, new Date(2017 - 10 - 15),
                new Item("thisistoolong", "for sure", BigDecimal.valueOf(100.5)))));

        orderRepository.addOrder(order, customer.getId());

        assertThat(entityManager.find(Order.class, order.getOrderId())).isEqualTo(order);
    }

    @After
    public void tearDown() throws Exception {
        entityManager.clear();
    }
}