package be.cegeka.orders.order.domain.items;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "ITEMS")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ITEM_ID")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;
    @Column(name = "SELLING_PRICE")
    private BigDecimal sellingPrice;

    private Item() {
    }

    public Item(String name, String description, BigDecimal sellingPrice) {
        this.name = name;
        this.description = description;
        this.sellingPrice = sellingPrice;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != item.id) return false;
        if (name != null ? !name.equals(item.name) : item.name != null) return false;
        if (description != null ? !description.equals(item.description) : item.description != null) return false;
        return sellingPrice != null ? sellingPrice.equals(item.sellingPrice) : item.sellingPrice == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (sellingPrice != null ? sellingPrice.hashCode() : 0);
        return result;
    }

    public Date getShippingDate() {

        if(isInStock()) {
            return java.sql.Date.valueOf(LocalDate.now().plusDays(1));
        } else {
            return java.sql.Date.valueOf(LocalDate.now().plusDays(7));
        }
    }

    public boolean isInStock() {
        return false; //No Stock implemented yet
    }

}
