package mk.ukim.finki.emt.productcatalog.services;

import mk.ukim.finki.emt.productcatalog.domain.models.Dish;
import mk.ukim.finki.emt.productcatalog.domain.models.DishId;
import mk.ukim.finki.emt.productcatalog.services.form.DishForm;

import java.util.List;

public interface DishService {
    Dish findById(DishId id);
    Dish createProduct(DishForm form);
    Dish orderItemCreated(DishId productId, int quantity);
    Dish orderItemRemoved(DishId productId, int quantity);
    List<Dish> getAll();

}
