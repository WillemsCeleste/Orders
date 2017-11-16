package be.cegeka.orders.order.domain.orders;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @Column(name = "ORDER_DATE")
    private Date date;
    @Column(name = "TOTAL_PRICE")
    private BigDecimal totalPrice;
    @Transient
    private List<Date> shippingDates;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ORDER_ID")
    private List<Itemgroup> itemgroup;

    public Order() {
    }

    public Order(Date date, List<Itemgroup> itemgroup) {
        this.date = date;
        this.itemgroup = itemgroup;
    }

    private void calculateTotalPrice(List<Itemgroup> itemgroup) {
        totalPrice = new BigDecimal(0);
        for (Itemgroup item : itemgroup) {
           totalPrice = totalPrice.add(item.getItemgroupPrice());
        }
    }

    public int getOrderId() {
        return orderId;
    }

    public Date getDate() {
        return date;
    }

    public List<Itemgroup> getItemsOnOrder() {
        return itemgroup;
    }

    public BigDecimal getTotalPrice(List<Itemgroup> itemgroup) {
        calculateTotalPrice(itemgroup);
        return totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return orderId == order.orderId;
    }

    @Override
    public int hashCode() {
        return orderId;
    }
}

