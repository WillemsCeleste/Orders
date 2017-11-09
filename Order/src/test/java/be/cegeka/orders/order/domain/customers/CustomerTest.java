package be.cegeka.orders.order.domain.customers;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class CustomerTest {

private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer(1,"Ralphie", "VanCampenHoudt", "ralphie@gmail.com", "diestsestraat 999", "016 320208");
    }

    @Test
    public void getId_shouldReturnId() throws Exception {
        assertThat(customer.getId()).isEqualTo(1);
    }

    @Test
    public void getName_shouldReturnName() throws Exception {
        assertThat(customer.getName()).isEqualTo("Ralphie");
    }

    @Test
    public void getLastName_shouldReturLastName() throws Exception {
        assertThat(customer.getLastName()).isEqualTo("VanCampenHoudt");
    }

    @Test
    public void getEmail_shouldReturnEmail() throws Exception {
        assertThat(customer.getEmail()).isEqualTo("ralphie@gmail.com");
    }

    @Test
    public void getAdress_shouldReturnAdress() throws Exception {
        assertThat(customer.getAdress()).isEqualTo("diestsestraat 999");
    }

    @Test
    public void getPhoneNumber_shouldReturnPhoneNumber() throws Exception {
        assertThat(customer.getPhoneNumber()).isEqualTo("016 320208");
    }
}