package be.cegeka.orders.order.domain.customers;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CustomerService {

    @Inject
    private CustomerRepository customerRepository;

    @Inject
    private CustomerMapper customerMapper;

    public Customer addCustomer(CustomerDto customerDto) {
        return customerRepository.addCustomer(customerMapper.makeCustomerFromDto(customerDto));
    }
}
