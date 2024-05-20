package mk.ukim.finki.emt.ordermanagement.service.forms;

import lombok.Data;
import lombok.NonNull;


import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import java.util.List;

//sodrzi atributi potrebni za kreiranje na edna naracka
@Data
public class OrderForm {

    @NonNull
    private Currency currency;

    @Valid
    @NotEmpty
    private List<OrderItemForm> items = new ArrayList<>();

}
