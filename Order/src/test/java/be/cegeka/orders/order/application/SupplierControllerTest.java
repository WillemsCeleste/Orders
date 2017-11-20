package be.cegeka.orders.order.application;

import be.cegeka.orders.order.domain.items.Item;
import be.cegeka.orders.order.domain.orders.ItemGroup;
import be.cegeka.orders.order.domain.orders.Order;
import be.cegeka.orders.order.domain.orders.SupplierService;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SupplierControllerTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    SupplierController supplierController;

    @Mock
    SupplierService supplierService;

    @Test
    public void getOrderListFromSupplier_shouldReturnOrderList() throws Exception {
        List<Order> orderList = new ArrayList();
        Mockito.when(supplierService.getOrderListFromSupplier()).thenReturn(orderList);
        Assertions.assertThat(supplierController.getOrderListFromSupplier()).isEqualTo(orderList);
    }
}