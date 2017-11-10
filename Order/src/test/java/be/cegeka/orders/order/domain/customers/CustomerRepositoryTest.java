package be.cegeka.orders.order.domain.customers;

import be.cegeka.orders.order.OrderApplication;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = OrderApplication.class)
@Transactional
public class CustomerRepositoryTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private CustomerRepository customerRepository;
    private Customer seppe, johan;

    @Before
    public void setupDatabase() {
        seppe = new Customer("Seppe", "Gielen","seppe@gmail.com","hasseltWhatever", "089 7331");
        johan = new Customer("Johan", "Vdw", "johan@gmail.com","cegekaVille", "016987456");

        entityManager.persist(seppe);
        entityManager.persist(johan);
    }

    @Test
    public void addCustomer_shouldAddCustomer() throws Exception {
        Customer testCustomer = new Customer("naam","achternaam", "email", "adres","nummer");
        customerRepository.addCustomer(testCustomer);
        assertThat( customerRepository.getAll() ).contains(seppe,johan,testCustomer);
        assertThat(customerRepository.getAll().size()).isEqualTo(3);

    }

    @Test
    public void getAllShouldReturnAll() throws Exception {
        assertThat(customerRepository.getAll()).contains(seppe, johan);
    }

    @After
    public void cleanDatabase(){
        entityManager.clear();
    }
}
