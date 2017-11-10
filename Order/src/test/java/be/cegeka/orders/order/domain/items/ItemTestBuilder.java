package be.cegeka.orders.order.domain.items;

import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;

public class ItemTestBuilder {

    private int id;
    private String name;
    private BigDecimal sellingPrice;
    private String description;

    public static ItemTestBuilder aItem() {
        return new ItemTestBuilder()
                .withName("Domien")
                .withSellingPrice(new BigDecimal(2.2))
                .withDescription("Appel");
    }

    public ItemTestBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ItemTestBuilder withSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
        return this;
    }

    public ItemTestBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public ItemTestBuilder withId(int id){
        this.id = id;
        return this;
    }
    public Item build(){
        Item item = new Item(name,description,sellingPrice);
        ReflectionTestUtils.setField(item,"id",id);
        return item;
    }
}
