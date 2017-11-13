package be.cegeka.orders.order.application;

import be.cegeka.orders.order.domain.customers.Customer;
import be.cegeka.orders.order.domain.customers.CustomerDto;
import org.junit.Before;
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

    private CustomerDto customerDto;

    @Before
    public void setUp() throws Exception {
        customerDto = new CustomerDto("Ralph", "Vancampenhoudt","ralph@gmail", "Leuven", "0497642465" );
    }

    @Test
    public void addCustomer_shouldActivateCorrespondingMethod() throws Exception {
        customerController.addCustomer(customerDto);
        verify(customerService).addCustomer(customerDto);
    }

}