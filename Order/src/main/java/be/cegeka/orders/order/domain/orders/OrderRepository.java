package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.items.Item;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Named
public class OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void addOrder(Order order, int customerId) {
        entityManager.find(Customer.class, customerId).addOrderToThisCustomer(order);
        entityManager.persist(order);
    }

    public Item getItemByID(int itemId) {
        return entityManager.find(Item.class, itemId);
    }
}
