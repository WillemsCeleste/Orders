package be.cegeka.orders.order.application;

import be.cegeka.orders.order.domain.customers.CustomerService;
import be.cegeka.orders.order.domain.items.ItemService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.math.BigDecimal;

@RestController
@RequestMapping(path = "/item")
@Transactional
public class ItemController {

    @Inject
    private ItemService itemService;

    @PostMapping
    public void addItem(@RequestParam(value = "name", required = true) String name,
                        @RequestParam (value = "description", required = true) String description,
                        @RequestParam (value = "selling_price", required = true)BigDecimal sellingPrice){
        itemService.addItem(name, description,sellingPrice);

    }
}
