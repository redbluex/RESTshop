package pl.redblue.shop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.redblue.shop.domain.Product;

@Repository
public interface ProductRepository extends MongoRepository <Product, String> {
}
