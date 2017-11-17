package be.cegeka.orders.supplier.domain;

import be.cegeka.orders.supplier.application.SupplierController;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class SupplierServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private SupplierService supplierService;

    @Mock
    private SupplierRepository supplierRepository;

    private StockOrder stockOrder;

    @Before
    public void setUp() throws Exception {
        stockOrder = new StockOrder(LocalDateTime.of(2017, 12, 03, 9, 30),
                "Kiki", "details of order");
    }

    @Test
    public void addStockOrder_ShouldCallCorrectMethod() throws Exception {
        supplierService.addStockOrder(stockOrder);
        verify(supplierRepository).addStockOrder(stockOrder);
    }

}