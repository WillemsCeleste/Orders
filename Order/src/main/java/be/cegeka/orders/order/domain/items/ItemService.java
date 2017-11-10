package be.cegeka.orders.order.domain.items;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;

@Named
public class ItemService {
    @Inject
    private ItemRepository itemRepository;

    public Item addItem(Item item) {
       return itemRepository.addItem(item);

    }
}
