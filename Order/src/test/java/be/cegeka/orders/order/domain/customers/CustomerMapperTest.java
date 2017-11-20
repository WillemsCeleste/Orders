package be.cegeka.orders.order.domain.customers;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.*;

public class CustomerMapperTest {

    @Test
    public void makeCustomerFromDto() throws Exception {
        CustomerMapper testMapper = new CustomerMapper();
        CustomerDto customerDto = new CustomerDto("Ralph", "Vacnampenhoudt", "ralph@gamil.com","Awesome Ville","0497642465");
        Customer customer = new Customer("Ralph", "Vacnampenhoudt", "ralph@gamil.com","Awesome Ville","0497642465");


        Assertions.assertThat(testMapper.makeCustomerFromDto(customerDto)).isEqualTo(customer);


    }

}