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
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SupplierApplication.class)
@Transactional
public class SupplierRepositoryTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private SupplierRepository supplierRepository;

    private StockOrder stockOrder, stockOrder2;

    private List<StockOrder> stockorders;

    @Before
    public void setUp() throws Exception {
        stockOrder = new StockOrder(LocalDateTime.of(2017, 12, 3, 9, 30),
                "Kiki", "details of order");
        stockOrder2 = new StockOrder(LocalDateTime.of(2017, 12, 03, 9, 30),
                "Seppe", "details of order");
        stockorders = new ArrayList<>();
        stockorders.add(stockOrder);
        stockorders.add(stockOrder2);
    }


    @Test
    public void addStockOrder_ShouldAddOrderToDatabase() throws Exception {
        supplierRepository.addStockOrder(stockOrder);
        Assertions.assertThat(entityManager.find(StockOrder.class, stockOrder.getId())).isEqualTo(stockOrder);
    }

    @Test
    public void getAllStockOrders_ShouldReturnAllStockOrders() throws Exception {
        supplierRepository.addStockOrder(stockOrder);
        supplierRepository.addStockOrder(stockOrder2);

        Assertions.assertThat(supplierRepository.getAllStockOrders()).contains(stockOrder, stockOrder2);
    }
}