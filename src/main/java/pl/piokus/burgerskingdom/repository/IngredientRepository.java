package pl.piokus.burgerskingdom.repository;

import org.springframework.data.repository.CrudRepository;
import pl.piokus.burgerskingdom.model.Ingredient;

public interface IngredientRepository
        extends CrudRepository<Ingredient, String> {

}
