package pl.redblue.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.redblue.shop.domain.Order;
import pl.redblue.shop.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderRestController {
    @Autowired
    OrderService orderService;

    @GetMapping("/allorders")
    public List<Order> getAllOrders(){
        return orderService.getObjects();
    }

    @PostMapping("/addorder")
    public Order addOrder(@RequestBody Order order){
        return orderService.create(order);
    }

}
