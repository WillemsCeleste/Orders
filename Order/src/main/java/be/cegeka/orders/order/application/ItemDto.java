package be.cegeka.orders.order.application;

import java.math.BigDecimal;

public class ItemDto {
    private String name;
    private String description;
    private BigDecimal sellingPrice;

    private ItemDto() {
    }

    public ItemDto(String name, String description, BigDecimal sellingPrice) {
        this.name = name;
        this.description = description;
        this.sellingPrice = sellingPrice;
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
}
