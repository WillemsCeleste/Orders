package be.cegeka.orders.order.domain.customers;

import org.junit.Before;
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

    @Mock
    private CustomerMapper customerMapper;

    private CustomerDto customerDto;

    @Before
    public void setUp() throws Exception {
        customerDto = new CustomerDto("Ralph", "Vancampenhoudt","ralph@gmail", "Leuven", "0497642465" );
    }

    @Test
    public void addCustomer_shouldCallUserRepository() throws Exception {
        customerService.addCustomer(customerDto);
        Mockito.verify(customerRepository).addCustomer(customerMapper.makeCustomerFromDto(customerDto));
    }

}