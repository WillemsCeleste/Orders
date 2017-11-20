package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.OrderApplication;
import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.items.Item;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

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

    private Customer customer, customer2;
    private Order order,order2;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("naam","achternaam","email","adres","phonenumber");
        customer2 = new Customer("naam2","achternaam2","email2","adres2","phonenumber2");
        entityManager.persist(customer);
        entityManager.persist(customer2);
        order = new Order(new Date(2017 - 10 - 15),
                Arrays.asList(new ItemGroup(1, new Date(2017 - 10 - 15),
                        new Item("thisistoolong", "for sure", BigDecimal.valueOf(100.5)))));
        order2 = new Order(new Date(2017 - 10 - 15),
                Arrays.asList(new ItemGroup(1, new Date(2017 - 10 - 15),
                        new Item("thisistoolong2", "for sure2", BigDecimal.valueOf(100.52)))));

    }


    @Test
    public void addOrder_shouldAddAnOrderToDatabase() throws Exception {
        Customer customer = new Customer("name", "noname", "blabla@gmail.com", "nope", "ringringbanaphone");
        entityManager.persist(customer);

        Customer customer1 = entityManager.find(Customer.class, customer.getId());

        Order order = new Order(new Date(2017 - 10 - 15),
                Arrays.asList(new ItemGroup(1, new Date(2017 - 10 - 15),
                new Item("thisistoolong", "for sure", BigDecimal.valueOf(100.5)))));

        orderRepository.addOrder(order, customer.getId());

        assertThat(entityManager.find(Order.class, order.getOrderId())).isEqualTo(order);
    }


    @Test
    public void getOrdersByCustomerId_shouldReturnTheListOfOrdersMadeByThisCutomer() throws Exception {
        orderRepository.addOrder(order,customer.getId());
        orderRepository.addOrder(order2,customer2.getId());
        assertThat(orderRepository.getOrdersByCustomerId(customer.getId())).containsExactly(order);
        }

    @After
    public void tearDown() throws Exception {
        entityManager.clear();
    }
}