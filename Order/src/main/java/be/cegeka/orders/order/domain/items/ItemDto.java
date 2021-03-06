package be.cegeka.orders.order.domain.items;

import java.math.BigDecimal;

public class ItemDto {
    public String name;
    public String description;
    public BigDecimal sellingPrice;

    public ItemDto() {
    }

    public ItemDto(String name, String description, BigDecimal sellingPrice) {
        this.name = name;
        this.description = description;
        this.sellingPrice = sellingPrice;
    }
}
