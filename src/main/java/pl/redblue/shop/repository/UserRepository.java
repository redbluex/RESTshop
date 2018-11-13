package pl.redblue.shop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.redblue.shop.domain.Users;


public interface UserRepository extends MongoRepository<Users, String> {
    Users findByUsername(String username);
}
