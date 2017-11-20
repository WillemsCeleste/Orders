package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.customers.Customer;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
public class OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void addOrder(Order order, Customer customer) {
        customer.addOrderToThisCustomer(order);
        entityManager.persist(order);
    }

    public List<Order> getOrdersByCustomerId(int customerId) {
        return null;
    }
}
