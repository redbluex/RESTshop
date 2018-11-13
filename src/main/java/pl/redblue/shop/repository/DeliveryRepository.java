package pl.redblue.shop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.redblue.shop.domain.Delivery;

@Repository
public interface DeliveryRepository extends MongoRepository<Delivery, String> {
}
