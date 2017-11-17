package be.cegeka.orders.supplier.application;

import be.cegeka.orders.supplier.domain.StockOrder;
import be.cegeka.orders.supplier.domain.SupplierService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.awt.*;

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

}
