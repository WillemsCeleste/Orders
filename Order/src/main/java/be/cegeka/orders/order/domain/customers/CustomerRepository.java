package be.cegeka.orders.order.domain.customers;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
public class CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Customer> getAllCustomers(){
        return entityManager.createQuery("select c from Customer c" , Customer.class).getResultList();
    }

    public Customer addCustomer(Customer customer) {
        entityManager.persist(customer);
        return customer;
    }

}
