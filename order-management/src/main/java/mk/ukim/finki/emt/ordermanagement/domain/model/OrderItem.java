package mk.ukim.finki.emt.ordermanagement.domain.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import mk.ukim.finki.emt.ordermanagement.domain.valueObjects.DishId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "order_item")
@Getter
public class OrderItem extends AbstractEntity<OrderItemId> {

    private Money itemPrice;

    @Column(name = "qty", nullable = false)
    private int quantity;

    @AttributeOverride(name = "id", column = @Column(name="dish_id", nullable = false))
    private DishId dishId;

    public Money subtotal() {
        return itemPrice.multiply(quantity);
    }


    public OrderItem() {
        super(DomainObjectId.randomId(OrderItemId.class));
    }

    public OrderItem(@NonNull DishId dishId, @NonNull Money itemPrice, int qty) {
        super(DomainObjectId.randomId(OrderItemId.class));
        this.dishId = dishId;
        this.itemPrice = itemPrice;
        this.quantity = qty;
    }


}
