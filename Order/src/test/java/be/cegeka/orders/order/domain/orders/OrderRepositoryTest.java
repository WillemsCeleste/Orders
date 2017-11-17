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
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = OrderApplication.class)
@Transactional
public class OrderRepositoryTest{

        @PersistenceContext
        private EntityManager entityManager;

        @Inject
        private OrderRepository orderRepository;

    @Test
    public void addOrder() throws Exception {
        Customer customer = new Customer("name", "noname", "blabla@gmail.com","nope", "ringringbanaphone");
        entityManager.persist(customer);

        Customer customer1 = entityManager.find(Customer.class, customer.getId());

        Order order = new Order(new Date(2017-10-15),
                        Arrays.asList(new Itemgroup(1,new Date(2017-10-15),
                        new Item("thisistoolong","for sure", BigDecimal.valueOf(100.5)))));
        orderRepository.addOrder(order, customer1);

        assertThat(entityManager.find(Order.class, order.getOrderId())).isEqualTo(order);
    }

    @After
    public void tearDown() throws Exception {
        entityManager.clear();
    }
}