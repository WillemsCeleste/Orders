package be.cegeka.orders.order.domain.items;

import javax.inject.Named;

@Named
public class ItemMapper {
    private Item item;

    public Item makeItemFromDto(ItemDto itemDto){
        item = new Item(itemDto.name,itemDto.description,itemDto.sellingPrice);
        return item;
    }
}
