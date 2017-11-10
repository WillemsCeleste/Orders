package be.cegeka.orders.order.domain.items;

import static be.cegeka.orders.order.domain.items.ItemTestBuilder.*;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemTest {

    private Item item;

    @Before
    public void setup() {
        item = aItem()
                .withDescription("Red Hug")
                .withId(10)
                .withName("Appel")
                .withSellingPrice(new BigDecimal(2.2))
                .build();
    }

    @Test
    public void getId() throws Exception {
        assertThat(item.getId()).isEqualTo(10);
    }

    @Test
    public void getName() throws Exception {
        assertThat(item.getName()).isEqualTo("Appel");
    }

    @Test
    public void getDescription() throws Exception {
        assertThat(item.getDescription()).isEqualTo("Red Hug");
    }

    @Test
    public void getSellingPrice() throws Exception {
        assertThat(item.getSellingPrice()).isEqualTo(new BigDecimal(2.2));
    }

    @Test
    public void equals_sameObject_isTrue() throws Exception {
        assertThat(item).isEqualTo(item);
    }

    @Test
    public void equals_ObjectWithSameIdAndName_isTrue() throws Exception {
        assertThat(item).isEqualTo(aItem()
                .withDescription("Red Hug")
                .withId(10)
                .withName("Appel")
                .withSellingPrice(new BigDecimal(2.2))
                .build()
        );
    }

    @Test
    public void equals_NullObject_isFalse() throws Exception {
        assertThat(item).isNotEqualTo(null);
    }

    @Test
    public void equals_OtherClass_isFalse() throws Exception {
        assertThat(item).isNotEqualTo(new Object());
    }

    @Test
    public void equals_ObjectWithOtherId_isFalse() throws Exception {
        assertThat(item).isNotEqualTo(aItem()
                .withDescription("Red Hug")
                .withId(8)
                .withName("Appel")
                .withSellingPrice(new BigDecimal(2.2))
                .build()
        );
    }

    @Test
    public void equals_ObjectWithOtherName_isFalse() throws Exception {
        assertThat(item).isNotEqualTo(aItem()
                .withDescription("Red Hug")
                .withId(10)
                .withName("Peer")
                .withSellingPrice(new BigDecimal(2.2))
                .build()
        );
    }

    @Test
    public void equals_ObjectWithNullName_IsFalse() throws Exception {
        assertThat(item).isNotEqualTo(aItem()
                .withDescription("Red Hug")
                .withId(10)
                .withName(null)
                .withSellingPrice(new BigDecimal(2.2))
                .build()
        );
    }

    @Test
    public void equals_ObjectWithBothNullName_IsTrue() throws Exception {
        assertThat(aItem()
                .withDescription("Red Hug")
                .withId(10)
                .withName(null)
                .withSellingPrice(new BigDecimal(2.2))
                .build())
                .isEqualTo(aItem()
                        .withDescription("Red Hug")
                        .withId(10)
                        .withName(null)
                        .withSellingPrice(new BigDecimal(2.2))
                        .build()
                );
    }

    @Test
    public void equals_ObjectWithNoNullName_IsFalse() throws Exception {
        assertThat(aItem()
                .withDescription("Red Hug")
                .withId(10)
                .withName(null)
                .withSellingPrice(new BigDecimal(2.2))
                .build())
                .isNotEqualTo(aItem()
                        .withDescription("Red Hug")
                        .withId(10)
                        .withName("Appel")
                        .withSellingPrice(new BigDecimal(2.2))
                        .build()
                );
    }

    @Test
    public void equals_ObjectWithOtherDescription_isFalse() throws Exception {
        assertThat(item).isNotEqualTo(aItem()
                .withDescription("Green Hug")
                .withId(10)
                .withName("Appel")
                .withSellingPrice(new BigDecimal(2.2))
                .build()
        );
    }

    @Test
    public void equals_ObjectWithNullDescription_IsFalse() throws Exception {
        assertThat(item).isNotEqualTo(aItem()
                .withDescription(null)
                .withId(10)
                .withName("Appel")
                .withSellingPrice(new BigDecimal(2.2))
                .build()
        );
    }

    @Test
    public void equals_ObjectWithBothNullDescription_IsTrue() throws Exception {
        assertThat(aItem()
                .withDescription(null)
                .withId(10)
                .withName("Appel")
                .withSellingPrice(new BigDecimal(2.2))
                .build())
                .isEqualTo(aItem()
                        .withDescription(null)
                        .withId(10)
                        .withName("Appel")
                        .withSellingPrice(new BigDecimal(2.2))
                        .build()
                );
    }

    @Test
    public void equals_ObjectWithNoNullDescription_IsFalse() throws Exception {
        assertThat(aItem()
                .withDescription(null)
                .withId(10)
                .withName("Appel")
                .withSellingPrice(new BigDecimal(2.2))
                .build())
                .isNotEqualTo(aItem()
                        .withDescription("Red Hug")
                        .withId(10)
                        .withName("Appel")
                        .withSellingPrice(new BigDecimal(2.2))
                        .build()
                );
    }

    @Test
    public void equals_ObjectWithOtherSellingPrice_isFalse() throws Exception {
        assertThat(item).isNotEqualTo(aItem()
                .withDescription("Red Hug")
                .withId(10)
                .withName("Appel")
                .withSellingPrice(new BigDecimal(1.2))
                .build()
        );
    }

    @Test
    public void equals_ObjectWithNullSellingPrice_IsFalse() throws Exception {
        assertThat(item).isNotEqualTo(aItem()
                .withDescription("Red Hug")
                .withId(10)
                .withName("Appel")
                .withSellingPrice(null)
                .build()
        );
    }

    @Test
    public void equals_ObjectWithBothNullSellingPrice_IsTrue() throws Exception {
        assertThat(aItem()
                .withDescription("Red Hug")
                .withId(10)
                .withName("Appel")
                .withSellingPrice(null)
                .build())
                .isEqualTo(aItem()
                        .withDescription("Red Hug")
                        .withId(10)
                        .withName("Appel")
                        .withSellingPrice(null)
                        .build()
                );
    }

    @Test
    public void equals_ObjectWithNoNullSellingPrice_IsFalse() throws Exception {
        assertThat(aItem()
                .withDescription("Red Hug")
                .withId(10)
                .withName("Appel")
                .withSellingPrice(null)
                .build())
                .isNotEqualTo(aItem()
                        .withDescription("Red Hug")
                        .withId(10)
                        .withName("Appel")
                        .withSellingPrice(new BigDecimal(2.2))
                        .build()
                );
    }
}