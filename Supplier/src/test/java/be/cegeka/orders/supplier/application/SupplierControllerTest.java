package be.cegeka.orders.supplier.application;

import be.cegeka.orders.supplier.domain.StockOrder;
import be.cegeka.orders.supplier.domain.SupplierService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SupplierControllerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private SupplierController supplierController;

    @Mock
    private SupplierService supplierService;

    private StockOrder stockOrder, stockOrder2;

    private List<StockOrder> stockorders;

    @Before
    public void setUp() throws Exception {
        stockOrder = new StockOrder(LocalDateTime.of(2017, 12, 03, 9, 30),
                                    "Kiki", "details of order");
        stockOrder2 = new StockOrder(LocalDateTime.of(2017, 12, 03, 9, 30),
                "Seppe", "details of order");
        stockorders = new ArrayList<>();
        stockorders.add(stockOrder);
        stockorders.add(stockOrder2);

    }

    @Test
    public void addStockOrder_ShouldActivateCorrectMethod() throws Exception {
        supplierController.addStockOrder(stockOrder);
        verify(supplierService).addStockOrder(stockOrder);
    }

    @Test
    public void getAllStockOrders_ShouldActivateCorrectMethod() throws Exception {
        when(supplierService.getAllStockOrders()).thenReturn(stockorders);

        List<StockOrder> actual = supplierController.getAllStockOrders();
        Assertions.assertThat(actual).isEqualTo(stockorders);
    }
}