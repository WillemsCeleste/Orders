package be.cegeka.orders.order.domain.customers;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
public class CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Customer> getAll(){
        return entityManager.createQuery("select c from Customer c" , Customer.class).getResultList();
    }

    public void addCustomer(String name, String lastName, String emailAdress, String adress, String phoneNumber) {
        entityManager.persist(new Customer(name, lastName, emailAdress, adress, phoneNumber));
    }
}
