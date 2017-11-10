package be.cegeka.orders.order.application;

import be.cegeka.orders.order.domain.customers.CustomerService;
import org.springframework.web.bind.annotation.*;


import javax.inject.Inject;
import javax.transaction.Transactional;

@RestController
@RequestMapping(path = "/customer")
@Transactional
public class CostumerController {

    @Inject
    private CustomerService customerService;

    @PostMapping
    public void addCustomer(@RequestParam(value = "name", required = true) String name,
                            @RequestParam(value = "lastName", required = true) String lastName,
                            @RequestParam(value = "emailAdress", required = true) String emailAdress,
                            @RequestParam(value = "adress", required = true) String adress,
                            @RequestParam(value = "phoneNumber", required = true) String phoneNumber) {
                        customerService.addCustomer(name, lastName, emailAdress, adress, phoneNumber);
    }


}
