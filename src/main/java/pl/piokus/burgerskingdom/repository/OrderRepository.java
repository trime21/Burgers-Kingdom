package pl.piokus.burgerskingdom.repository;

import org.springframework.data.repository.CrudRepository;
import pl.piokus.burgerskingdom.model.Order;


public interface OrderRepository extends CrudRepository<Order, Long> {


}
