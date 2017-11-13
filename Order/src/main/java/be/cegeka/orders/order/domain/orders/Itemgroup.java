package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.items.Item;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ITEMGROUP")
public class Itemgroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iooId;
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
        this.itemgroupPrice = item.getSellingPrice().multiply(BigDecimal.valueOf(amount));
        this.shippingDate = shippingDate;
        this.item = item;
    }

    public int getId() {
        return iooId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Itemgroup itemgroup = (Itemgroup) o;

        return iooId == itemgroup.iooId;
    }

    @Override
    public int hashCode() {
        return iooId;
    }
}
