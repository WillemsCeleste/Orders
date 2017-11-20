package be.cegeka.orders.order.application;


import be.cegeka.orders.order.domain.orders.Order;
import be.cegeka.orders.order.domain.orders.SupplierService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(path= "/supplierTest")
@Transactional
@Named
public class SupplierController {

    @Inject
    SupplierService supplierService;

    public List<Order> getOrderListFromSupplier() {
        return supplierService.getOrderListFromSupplier();
    }
}
