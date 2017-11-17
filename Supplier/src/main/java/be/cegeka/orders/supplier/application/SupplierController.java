package be.cegeka.orders.supplier.application;

import be.cegeka.orders.supplier.domain.StockOrder;
import be.cegeka.orders.supplier.domain.SupplierService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(path = "/supplier")
@Transactional
public class SupplierController {

    @Inject
    private SupplierService supplierService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public StockOrder addStockOrder(@RequestBody StockOrder stockOrder){
        return supplierService.addStockOrder(stockOrder);
    }

    @GetMapping
    public List<StockOrder> getAllStockOrders() {
        return supplierService.getAllStockOrders();
    }

}
