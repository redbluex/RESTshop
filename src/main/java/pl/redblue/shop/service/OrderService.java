package pl.redblue.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.redblue.shop.domain.Order;
import pl.redblue.shop.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService implements ServiceInterface<Order> {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> getObjects() {
        return orderRepository.findAll();
    }

    @Override
    public Order create(Order obj) {
        return orderRepository.save(obj);
    }

    @Override
    public Order findById(String id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public Order update(String id, Order obj) {
        return null;
    }
}
