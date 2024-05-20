package mk.ukim.finki.emt.productcatalog.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.springframework.lang.NonNull;

public class DishId extends DomainObjectId {

    public Money price;
    public String dishName;
    public int sales;

    DishId() {
        super(DishId.randomId(DishId.class).getId());
    }

    public DishId(@NonNull String uuid) {
        super(uuid);
    }

    public static DishId of(String uuid) {
        DishId p = new DishId(uuid);
        return p;
    }


}
