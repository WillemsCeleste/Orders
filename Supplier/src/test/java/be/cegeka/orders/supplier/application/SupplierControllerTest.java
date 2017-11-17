package be.cegeka.orders.supplier.application;

import be.cegeka.orders.supplier.domain.StockOrder;
import be.cegeka.orders.supplier.domain.SupplierService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.sql.Date;
import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class SupplierControllerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private SupplierController supplierController;

    @Mock
    private SupplierService supplierService;

    private StockOrder stockOrder;

    @Before
    public void setUp() throws Exception {
        stockOrder = new StockOrder(LocalDateTime.of(2017, 12, 03, 9, 30),
                                    "Kiki", "details of order");
    }

    @Test
    public void addStockOrder_ShouldActivateCorrectMethod() throws Exception {
        supplierController.addStockOrder(stockOrder);
        verify(supplierService).addStockOrder(stockOrder);
    }
}