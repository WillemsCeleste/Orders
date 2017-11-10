package be.cegeka.orders.order.domain.items;

import be.cegeka.orders.order.application.ItemDto;

import javax.inject.Named;

@Named
public class ItemMapper {
    private Item item;

    public Item makeItemFromDto(ItemDto itemDto){
        item = new Item(itemDto.getName(),itemDto.getDescription(),itemDto.getSellingPrice());
        return item;
    }
}
