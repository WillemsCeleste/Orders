package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.items.Item;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
public class OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void addOrder(Order order, int customerId) {
        entityManager.find(Customer.class, customerId).addOrderToThisCustomer(order);
        entityManager.persist(order);
    }

    public List<Order> getOrdersByCustomerId(int customerId) {
        return entityManager.createQuery("select o from Order o join Customer c on c.customerOrders where c.id =: customerId")
                .setParameter("customerId",customerId).getResultList();
    }

    public Item getItemByID(int itemId) {
        return entityManager.find(Item.class, itemId);
    }
}
