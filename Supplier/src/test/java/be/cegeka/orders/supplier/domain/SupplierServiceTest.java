package be.cegeka.orders.supplier.domain;

import be.cegeka.orders.supplier.application.SupplierController;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SupplierServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private SupplierService supplierService;

    @Mock
    private SupplierRepository supplierRepository;

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
    public void addStockOrder_ShouldCallCorrectMethod() throws Exception {
        supplierService.addStockOrder(stockOrder);
        verify(supplierRepository).addStockOrder(stockOrder);
    }

    @Test
    public void GetAllStockOrders_ShouldActivateCorrectMethod() throws Exception {
        when(supplierRepository.getAllStockOrders()).thenReturn(stockorders);

        List<StockOrder> actual = supplierService.getAllStockOrders();
        Assertions.assertThat(actual).isEqualTo(stockorders);
    }
}