package be.cegeka.orders.order.domain.customers;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CustomerService {

    @Inject
    private CustomerRepository customerRepository;

    public void addCustomer(String name, String lastName, String emailAdress, String adress, String phoneNumber) {
        customerRepository.addCustomer(new Customer(name, lastName, emailAdress, adress, phoneNumber));
    }
}
