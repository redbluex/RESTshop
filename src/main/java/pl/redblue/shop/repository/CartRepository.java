package pl.redblue.shop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.redblue.shop.domain.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {
}
