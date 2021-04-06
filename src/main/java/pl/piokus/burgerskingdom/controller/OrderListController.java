package pl.piokus.burgerskingdom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.piokus.burgerskingdom.model.Order;
import pl.piokus.burgerskingdom.repository.OrderRepository;

import java.util.Optional;


@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderListController {

    private OrderRepository orderRepo;

    public OrderListController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/list")
    public String orderList(Model model) {
        model.addAttribute("orders", orderRepo.findAll());
        return "orderList";
    }

    @GetMapping("deleteOrder")
    public String deleteOrder(@RequestParam("orderId") long id) {
        orderRepo.deleteById(id);

        return "redirect:/orders/list";
    }

    @GetMapping("editOrder")
    public String editOrder(@RequestParam("orderId") long id, Model model) {

        Optional<Order> order = orderRepo.findById(id);
        model.addAttribute("order", order);

        return "redirect:/orders/current";
    }

}
