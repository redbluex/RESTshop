package pl.redblue.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.redblue.shop.domain.Delivery;
import pl.redblue.shop.repository.DeliveryRepository;

import java.util.List;

@Service
public class DeliveryService implements ServiceInterface<Delivery> {

    @Autowired
    DeliveryRepository deliveryRepository;

    @Override
    public List<Delivery> getObjects() {
        return deliveryRepository.findAll();
    }

    @Override
    public Delivery create(Delivery obj) {
        return deliveryRepository.save(obj);
    }

    @Override
    public Delivery findById(String id) {
        return deliveryRepository.findById(id).get();
    }

    @Override
    public Delivery update(String id, Delivery obj) {
        return null;
    }
}
