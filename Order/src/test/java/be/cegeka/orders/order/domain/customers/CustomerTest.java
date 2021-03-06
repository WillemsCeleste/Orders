package be.cegeka.orders.order.domain.customers;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class CustomerTest {

    private Customer customer;
    private Customer customer2;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("Ralphie", "VanCampenHoudt", "ralphie@gmail.com", "diestsestraat 999", "016 320208");
        customer2 = new Customer("Ralphie", "VanCampenHoudt", "ralphie@gmail.com", "diestsestraat 999", "016 320208");
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

    @Test
    public void equals_sameObject_isTrue() throws Exception {
        assertThat(customer).isEqualTo(customer);
    }

    @Test
    public void equals_CustomerWithDifferentIdIsFalse() throws Exception {
        ReflectionTestUtils.setField(customer2,"id",54);
        assertThat(customer).isNotEqualTo(customer2);
    }

    @Test
    public void equals_objectWithSameEverything_isTrue() throws Exception {
        Customer expected = new Customer("Ralphie", "VanCampenHoudt", "ralphie@gmail.com", "diestsestraat 999", "016 320208");
        assertThat(customer).isEqualTo(expected);
    }

    @Test
    public void equals_nullObject_isFalse() throws Exception {
        assertThat(customer).isNotEqualTo(null);
    }

    @Test
    public void equals_otherClass_isFalse() throws Exception {
        assertThat(customer).isNotEqualTo(new Object());
    }

    @Test
    public void equals_objectWithOtherName_isFalse() throws Exception {
        Customer expectedFalse = new Customer("Rolphie", "VanCampenHoudt", "ralphie@gmail.com", "diestsestraat 999", "016 320208");
        assertThat(customer).isNotEqualTo(expectedFalse);
    }

    @Test
    public void equals_objectWithNullName_isFalse() throws Exception {
        Customer expectedNullName = new Customer(null, "VanCampenHoudt", "ralphie@gmail.com", "diestsestraat 999", "016 320208");
        assertThat(customer).isNotEqualTo(expectedNullName);
    }

    @Test
    public void equals_objectWithBothNullName_isFalse() throws Exception {
        Customer expectedBothNullName = new Customer(null, null, "ralphie@gmail.com", "diestsestraat 999", "016 320208");
        assertThat(customer).isNotEqualTo(expectedBothNullName);
    }


    @Test
    public void equals_objectWithotherEmail_isFalse() throws Exception {
        Customer expectedFalse = new Customer("Ralphie", "VanCampenHoudt", "ralphie@.com", "diestsestraat 999", "016 320208");
        assertThat(customer).isNotEqualTo(expectedFalse);
    }


    @Test
    public void equals_objectWithotherAdress_isFalse() throws Exception {
        Customer expectedFalse = new Customer("Ralphie", "VanCampenHoudt", "ralphie@gmail.com", "straat 999", "016 320208");
        assertThat(customer).isNotEqualTo(expectedFalse);
    }


    @Test
    public void equals_objectWithotherPhoneNr_isFalse() throws Exception {
        Customer expectedFalse = new Customer("Ralphie", "VanCampenHoudt", "ralphie@gmail.com", "diestsestraat 999", "016");
        assertThat(customer).isNotEqualTo(expectedFalse);
    }



}