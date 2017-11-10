package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.items.Item;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ITEMS_ON_ORDER")
public class Itemgroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "AMOUNT")
    private int amount;
    @Column(name = "ITEMGROUP_PRICE")
    private BigDecimal itemgroupPrice;
    @Column(name = "SHIPPING_DATE")
    private Date shippingDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    public Itemgroup() {
    }

    public Itemgroup(int amount, Date shippingDate, Item item) {
        this.amount = amount;
        this.itemgroupPrice = new BigDecimal(item.getSellingPrice() * amount);
        this.shippingDate = shippingDate;
        this.item = item;
    }

    //Method for groupprice
    public BigDecimal calculateItemgroupPrice() {
        return item.getSellingPrice() * amount;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public BigDecimal getItemgroupPrice() {
        return itemgroupPrice;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public Item getItem() {
        return item;
    }
}
