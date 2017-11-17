package be.cegeka.orders.supplier.domain;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
public class SupplierRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public StockOrder addStockOrder(StockOrder stockOrder) {
        entityManager.persist(stockOrder);
        return stockOrder;
    }
}
