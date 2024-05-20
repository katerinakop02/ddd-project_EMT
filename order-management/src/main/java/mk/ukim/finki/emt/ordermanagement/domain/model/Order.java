package mk.ukim.finki.emt.ordermanagement.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import mk.ukim.finki.emt.ordermanagement.domain.valueObjects.Dish;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import org.springframework.lang.NonNull;

import java.time.Instant;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
public class Order extends AbstractEntity<OrderId> {

    private Instant orderedOn;

    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    private Money total;

    @Column(name = "order_currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    //EAGER za koga pristapuvame do nekoj order da se listaat site stavki
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<OrderItem> orderItemList;

    public Order() {
        super(OrderId.randomId(OrderId.class));
    }


    public Order(Instant now, Currency currency) {
        super(OrderId.randomId(OrderId.class));
        this.orderedOn = now;
        this.currency=currency;
    }

    public Money total(){
        return orderItemList.stream().map(OrderItem::subtotal).reduce(new Money(currency, 0), Money::add);
    }

    public OrderItem addItem(@NonNull Dish dish, int qty) {
        Objects.requireNonNull(dish,"dish must not be null");
        var item  = new OrderItem(dish.getId(),dish.getPrice(),qty);
        orderItemList.add(item);
        return item;
    }

    public void removeItem(@NonNull OrderItemId orderItemId) {
        Objects.requireNonNull(orderItemId,"Order Item must not be null");
        orderItemList.removeIf(v->v.getId().equals(orderItemId));
    }

}
