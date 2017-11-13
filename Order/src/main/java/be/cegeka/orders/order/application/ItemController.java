package be.cegeka.orders.order.application;

import be.cegeka.orders.order.domain.customers.CustomerService;
import be.cegeka.orders.order.domain.items.Item;
import be.cegeka.orders.order.domain.items.ItemService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.lang.reflect.Method;
import java.math.BigDecimal;

@RestController
@RequestMapping(path = "/item")
@Transactional
public class ItemController {

    @Inject
    private ItemService itemService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Item addItem(@RequestBody ItemDto itemDto){
        return itemService.addItem(itemDto);

    }
}
