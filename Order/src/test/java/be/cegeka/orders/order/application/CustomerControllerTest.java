package be.cegeka.orders.order.application;

import org.junit.Rule;
import org.junit.Test;
import be.cegeka.orders.order.domain.customers.CustomerService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class CustomerControllerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;

    @Test
    public void addCustomer_shouldActivateCorrespondingMethod() throws Exception {
        customerController.addCustomer("Ralph", "Vancampenhoudt","ralph@gmail", "Leuven", "0497642465" );
        verify(customerService).addCustomer("Ralph", "Vancampenhoudt","ralph@gmail", "Leuven", "0497642465");
    }

}