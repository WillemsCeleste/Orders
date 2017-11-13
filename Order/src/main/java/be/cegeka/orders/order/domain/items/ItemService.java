package be.cegeka.orders.order.domain.items;

import be.cegeka.orders.order.application.ItemDto;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ItemService {

    @Inject
    ItemMapper itemMapper;

    @Inject
    private ItemRepository itemRepository;

    public Item addItem(ItemDto itemDto) {
        return itemRepository.addItem(itemMapper.makeItemFromDto(itemDto));

    }
}
