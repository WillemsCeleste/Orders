package be.cegeka.orders.order.application;

import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.customers.CustomerDto;
import be.cegeka.orders.order.domain.customers.CustomerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "/customer")
@Transactional
public class CustomerController {

    @Inject
    private CustomerService customerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Customer addCustomer(@RequestBody CustomerDto customerDto){
                        return customerService.addCustomer(customerDto);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }


}
