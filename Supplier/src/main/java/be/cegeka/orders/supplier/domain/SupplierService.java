package be.cegeka.orders.supplier.domain;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class SupplierService {

    @Inject
    private SupplierRepository supplierRepository;


    public StockOrder addStockOrder(StockOrder stockOrder) {
        stockOrder.timestampThisOrder();
        return supplierRepository.addStockOrder(stockOrder);
    }
}
