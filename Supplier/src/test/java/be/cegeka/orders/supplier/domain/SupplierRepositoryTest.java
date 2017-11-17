package be.cegeka.orders.supplier.domain;

import be.cegeka.orders.supplier.SupplierApplication;
import javafx.application.Application;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SupplierApplication.class)
@Transactional
public class SupplierRepositoryTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private SupplierRepository supplierRepository;

    private StockOrder stockOrder;

    @Before
    public void setUp() throws Exception {
        stockOrder = new StockOrder(LocalDateTime.of(2017, 12, 3, 9, 30),
                "Kiki", "details of order");
    }


    @Test
    public void addStockOrder_ShouldAddOrderToDatabase() throws Exception {
        supplierRepository.addStockOrder(stockOrder);
        Assertions.assertThat(entityManager.find(StockOrder.class, stockOrder.getId())).isEqualTo(stockOrder);
    }

}