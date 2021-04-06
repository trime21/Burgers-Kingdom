package pl.piokus.burgerskingdom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.piokus.burgerskingdom.repository.IngredientRepository;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {

    private IngredientRepository ingredientRepo;

    public IngredientController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }


}
