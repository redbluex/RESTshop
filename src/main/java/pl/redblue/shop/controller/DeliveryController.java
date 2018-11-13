package pl.redblue.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.redblue.shop.domain.Delivery;
import pl.redblue.shop.service.DeliveryService;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    DeliveryService deliveryService;

    @GetMapping("/all")
    List<Delivery> getAll(){
        return deliveryService.getObjects();
    }

    @PostMapping("/adddelivery")
    Delivery addDelivery(@RequestBody Delivery delivery){
        return deliveryService.create(delivery);
    }

    @GetMapping("/delivery/single/{id}")
    Delivery getDeliveryById(@PathVariable String id){
        return deliveryService.findById(id);
    }

}
