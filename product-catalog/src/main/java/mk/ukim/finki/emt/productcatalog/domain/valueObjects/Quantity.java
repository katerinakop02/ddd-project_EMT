package mk.ukim.finki.emt.productcatalog.domain.valueObjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

@Embeddable
@Getter
public class Quantity implements ValueObject {

    //immutable
    private final int quantity;

    protected Quantity() {
        this.quantity = 0;
    }

}
