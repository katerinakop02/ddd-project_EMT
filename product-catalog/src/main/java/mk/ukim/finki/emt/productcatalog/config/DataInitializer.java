package mk.ukim.finki.emt.productcatalog.config;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.productcatalog.domain.models.Dish;
import mk.ukim.finki.emt.productcatalog.domain.repository.DishRepository;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final DishRepository dishRepository;

    @PostConstruct
    public void initData() {
        Dish d1 = Dish.build("Pizza", Money.valueOf(Currency.MKD,500), 10);
        Dish d2 = Dish.build("Ice Cream", Money.valueOf(Currency.MKD,100), 5);
        if (dishRepository.findAll().isEmpty()) {
            dishRepository.saveAll(Arrays.asList(d1,d2));
        }
    }
}
