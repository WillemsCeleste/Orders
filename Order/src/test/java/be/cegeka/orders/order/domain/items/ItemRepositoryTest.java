package be.cegeka.orders.order.domain.items;

import be.cegeka.orders.order.OrderApplication;
import javafx.application.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static be.cegeka.orders.order.domain.items.ItemTestBuilder.aItem;
import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = OrderApplication.class)
@Transactional
public class ItemRepositoryTest {

    @Inject
    ItemRepository itemRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private Item appel, peer;

    @Before
    public void setUp() {
        appel = aItem()
                .withDescription("Red Hug")
                .withName("Appel")
                .withSellingPrice(new BigDecimal(2.2))
                .build();
        peer = aItem()
                .withDescription("Green Dude")
                .withName("Peer")
                .withSellingPrice(new BigDecimal(1.5))
                .build();
    }

    @Test
    public void addItem() throws Exception {
        itemRepository.addItem(appel);
                assertThat(entityManager.find(Item.class,appel.getId())).isEqualTo(appel);
    }
}