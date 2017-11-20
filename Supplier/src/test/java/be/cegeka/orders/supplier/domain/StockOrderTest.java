package be.cegeka.orders.supplier.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class StockOrderTest {

    private StockOrder stockOrder = new StockOrder(null, "Itchy Butthole", "wa details eh");

    @Test
    public void timestampThisOrder_shouldTimestampThisOrder() throws Exception {
        stockOrder.timestampThisOrder();
        Assertions.assertThat(stockOrder.getTimestamp()).isNotNull();
    }

}