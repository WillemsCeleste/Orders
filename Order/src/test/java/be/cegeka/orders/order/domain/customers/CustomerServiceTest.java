package be.cegeka.orders.order.domain.customers;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


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

    private List<Customer> customers;

    @Before
    public void setUp() throws Exception {
        Customer erwin = new Customer("Erwin", "Jacobs", "erwin@mail.be", "Zonhoven", "011784512");
        Customer kiki = new Customer("Kiki", "Willems", "kiki@mail.be", "Leuven", "016784512");
        Customer nelson = new Customer("Nelson", "De Kat", "geenwantkat", "Leuven", "ookgeenwantkat");

        customers = new ArrayList<>();
        customers.add(erwin);
        customers.add(kiki);
        customers.add(nelson);

        customerDto = new CustomerDto("Ralph", "Vancampenhoudt","ralph@gmail", "Leuven", "0497642465" );
    }

    @Test
    public void addCustomer_shouldCallCustomerRepository() throws Exception {
        customerService.addCustomer(customerDto);
        Mockito.verify(customerRepository).addCustomer(customerMapper.makeCustomerFromDto(customerDto));
    }

    @Test
    public void getAllCustomers_ShouldActivateCorrespondingMethod() throws Exception {
        when(customerRepository.getAllCustomers()).thenReturn(customers);

        List<Customer> actual = customerService.getAllCustomers();
        Assertions.assertThat(actual).isEqualTo(customers);
    }
}