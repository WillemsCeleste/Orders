package be.cegeka.orders.order.domain.orders;

import be.cegeka.orders.order.domain.items.Item;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class ItemGroupMapper {

    @Inject
    private OrderRepository orderRepository;

    public List<ItemGroup> makeItemGroupList(List<ItemGroupDto> itemGroupDtoList) {
        List<ItemGroup> itemGroupList = new ArrayList<>();
        for (ItemGroupDto i: itemGroupDtoList) {
            itemGroupList.add(makeItemGroup(i));
        }
        return itemGroupList;
    }

    public ItemGroup makeItemGroup(ItemGroupDto itemGroupDto){

        Item item = orderRepository.getItemByID(itemGroupDto.itemId);
     return new ItemGroup(itemGroupDto.amount, item.getShippingDate(), item);
    }
}
