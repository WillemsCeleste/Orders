package be.cegeka.orders.order.domain.customers;

import javax.inject.Named;

@Named
public class CustomerMapper {

    private Customer customer;

    public Customer makeCustomerFromDto(CustomerDto customerDto) {
        customer = new Customer(customerDto.name, customerDto.lastName, customerDto.email, customerDto.adress, customerDto.phoneNumber);
        return customer;
    }
}
