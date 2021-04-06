package pl.piokus.burgerskingdom.repository;

import org.springframework.data.repository.CrudRepository;
import pl.piokus.burgerskingdom.model.Burger;

public interface BurgerRepository extends CrudRepository<Burger, Long> {
}
