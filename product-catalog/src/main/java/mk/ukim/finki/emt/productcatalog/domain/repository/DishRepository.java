package mk.ukim.finki.emt.productcatalog.domain.repository;

import mk.ukim.finki.emt.productcatalog.domain.models.Dish;
import mk.ukim.finki.emt.productcatalog.domain.models.DishId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, DishId> {
}
