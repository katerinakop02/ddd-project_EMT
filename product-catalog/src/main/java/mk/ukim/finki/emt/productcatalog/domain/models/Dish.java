package mk.ukim.finki.emt.productcatalog.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Entity
@Table(name="dish")
@Getter
public class Dish extends AbstractEntity<DishId> {

    private String dishName;

    private int sales = 0;

    private Money price;

    public Dish() {
        super(DishId.randomId(DishId.class));
    }

    public static Dish build(String dishName, Money price, int sales) {
        Dish p = new Dish();
        p.price = price;
        p.dishName = dishName;
        p.sales = sales;
        return p;
    }

    public void addSales(int qty) {
        this.sales = this.sales - qty;
    }

    public void removeSales(int qty) {
        this.sales -= qty;
    }

}
