package be.cegeka.orders.order.domain.orders;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ORDER_DATE")
    private Date date;
    @Column(name = "TOTAL_PRICE")
    private BigDecimal totalPrice;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ORDER_ID")
    private List<Itemgroup> itemgroup;

    public Order() {
    }

    public Order(Date date, List<Itemgroup> itemgroup) {
        this.date = date;
        this.totalPrice = totalPrice;
        this.itemgroup = itemgroup;
    }

    //Method for totalPrice


    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public List<Itemgroup> getItemsOnOrder() {
        return itemgroup;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
}

