package mk.ukim.finki.emt.productcatalog.services.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.productcatalog.domain.exceptions.DishNotFoundException;
import mk.ukim.finki.emt.productcatalog.domain.models.Dish;
import mk.ukim.finki.emt.productcatalog.domain.models.DishId;
import mk.ukim.finki.emt.productcatalog.domain.repository.DishRepository;
import mk.ukim.finki.emt.productcatalog.services.DishService;
import mk.ukim.finki.emt.productcatalog.services.form.DishForm;
import org.springframework.stereotype.Service;

import java.util.List;

import static mk.ukim.finki.emt.productcatalog.domain.models.Dish.*;

@Service
@Transactional
@AllArgsConstructor
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;
    @Override
    public Dish findById(DishId id) {
        return dishRepository.findById(id).orElseThrow();
    }

    @Override
    public Dish createProduct(DishForm form) {
        Dish p = build(form.getProductName(),form.getPrice(),form.getSales());
        dishRepository.save(p);
        return p;

    }

    @Override
    public Dish orderItemCreated(DishId productId, int quantity) {
        Dish p = dishRepository.findById(productId).orElseThrow(DishNotFoundException::new);
        p.addSales(quantity);
        dishRepository.saveAndFlush(p);
        return p;

    }

    @Override
    public Dish orderItemRemoved(DishId productId, int quantity) {
        Dish p = dishRepository.findById(productId).orElseThrow(DishNotFoundException::new);
        p.removeSales(quantity);
        dishRepository.saveAndFlush(p);
        return p;

    }

    @Override
    public List<Dish> getAll() {
        return dishRepository.findAll();
    }
}
