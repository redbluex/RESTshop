package pl.redblue.shop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.redblue.shop.domain.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
}
