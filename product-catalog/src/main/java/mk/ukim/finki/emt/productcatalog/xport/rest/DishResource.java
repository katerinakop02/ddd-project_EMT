package mk.ukim.finki.emt.productcatalog.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.productcatalog.domain.models.Dish;
import mk.ukim.finki.emt.productcatalog.services.DishService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dish")
@AllArgsConstructor

public class DishResource {

    private final DishService dishService;

    @GetMapping
    public List<Dish> getAll() {
        return dishService.getAll();
    }

}
