package be.cegeka.orders.order.domain.customers;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;



public class CustomerServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();


    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void addCustomer_shouldCallUserRepository() throws Exception {
        customerService.addCustomer("Kiki", "kiki", "kiki@gmail","kikiville", "0467542192");
        Mockito.verify(customerRepository).addCustomer(new Customer("Kiki", "kiki", "kiki@gmail","kikiville", "0467542192"));
    }

}