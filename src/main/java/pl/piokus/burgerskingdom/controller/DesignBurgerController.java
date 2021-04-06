package pl.piokus.burgerskingdom.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.piokus.burgerskingdom.model.Burger;
import pl.piokus.burgerskingdom.model.Ingredient;
import pl.piokus.burgerskingdom.model.Ingredient.Type;
import pl.piokus.burgerskingdom.model.Order;
import pl.piokus.burgerskingdom.repository.BurgerRepository;
import pl.piokus.burgerskingdom.repository.IngredientRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignBurgerController {

    private final IngredientRepository ingredientRepo;
    private BurgerRepository burgerRepo;

    @Autowired
    public DesignBurgerController(IngredientRepository ingredientRepo, BurgerRepository burgerRepo) {
        this.ingredientRepo = ingredientRepo;
        this.burgerRepo = burgerRepo;
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "design")
    public Burger design() {
        return new Burger();
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(ingredients::add);

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid @ModelAttribute("design") Burger burger, Errors errors, @ModelAttribute Order order) {
        if (errors.hasErrors()) {
            return "design";
        }

        Burger saved = burgerRepo.save(burger);
        order.addDesign(saved);
        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
