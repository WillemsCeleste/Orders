package be.cegeka.orders.supplier.domain;

import org.glassfish.jersey.internal.inject.Custom;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "STOCKORDERS")
public class StockOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STOCKORDER_ID")
    private int id;

    @Column(name = "TIMEBOUGHT")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime timestamp;

    @Column(name = "CUSTOMERNAME")
    private String customername;

    @Column(name = "DETAILS_OF_ORDER")
    private String detailsOfOrder;

    public StockOrder() {
    }

    public StockOrder(LocalDateTime timestamp, String customername, String detailsOfOrder) {
        this.timestamp = timestamp;
        this.customername = customername;
        this.detailsOfOrder = detailsOfOrder;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getCustomername() {
        return customername;
    }

    public String getDetailsOfOrder() {
        return detailsOfOrder;
    }

    public int getId() {
        return id;
    }
}
