package org.sysco.soap;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import io.spring.guides.gs_producing_web_service.Meal;
import io.spring.guides.gs_producing_web_service.Currency;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Created by chamarap on 3/26/17.
 */
@Component
public class MealRepository {
    private static final List<Meal> meals = new ArrayList<Meal>();

    @PostConstruct
    public void initData() {
        Meal meatloaf = new Meal();
        meatloaf.setName("MeatLoaf");
        meatloaf.setCategory("NonVeg");
        meatloaf.setCurrency(Currency.EUR);
        meatloaf.setPrice(230);

        meals.add(meatloaf);

        Meal applePie = new Meal();
        applePie.setName("ApplePie");
        applePie.setCategory("Sweet");
        applePie.setCurrency(Currency.PLN);
        applePie.setPrice(350);

        meals.add(applePie);

        Meal pizza = new Meal();
        pizza.setName("Pizza");
        pizza.setCategory("Bakery");
        pizza.setCurrency(Currency.GBP);
        pizza.setPrice(1500);

        meals.add(pizza);
    }

    public Meal findMeal(String name) {
        Assert.notNull(name);

        Meal result = null;

        for (Meal Meal : meals) {
            if (name.equals(Meal.getName())) {
                result = Meal;
            }
        }

        return result;
    }
}