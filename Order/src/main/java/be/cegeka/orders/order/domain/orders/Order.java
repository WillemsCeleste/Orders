package be.cegeka.orders.order.domain.orders;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
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
    @JoinColumn(name = "ORDER_ID", nullable = false)
    private List<ItemGroup> itemGroupList=new ArrayList<>();

    public Order() {
    }

    public Order(Date date, List<ItemGroup> itemGroup) {
        this.date = date;
        this.itemGroupList = itemGroup;
    }

    private void calculateTotalPrice(List<ItemGroup> itemGroup) {
        totalPrice = new BigDecimal(0);
        for (ItemGroup item : itemGroup) {
           totalPrice = totalPrice.add(item.getItemgroupPrice());
        }
    }

    public int getOrderId() {
        return orderId;
    }

    public Date getDate() {
        return date;
    }

    public List<ItemGroup> getItemsOnOrder() {
        return itemGroupList;
    }

    public BigDecimal getTotalPrice(List<ItemGroup> itemGroup) {
        calculateTotalPrice(itemGroup);
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

