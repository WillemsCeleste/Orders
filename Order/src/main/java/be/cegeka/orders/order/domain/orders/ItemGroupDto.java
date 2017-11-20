package be.cegeka.orders.order.domain.orders;

public class ItemGroupDto {

    public int amount;
    public int itemId;

    public ItemGroupDto() {
    }


    public ItemGroupDto(int amount, int itemId) {
        this.amount = amount;
        this.itemId = itemId;
    }
}
