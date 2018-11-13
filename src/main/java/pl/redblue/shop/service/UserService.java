package pl.redblue.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.redblue.shop.domain.Users;
import pl.redblue.shop.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements ServiceInterface<Users> {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public List<Users> getObjects() {
        return null;
    }

    @Override
    public Users create(Users obj) {
        obj.setPassword(passwordEncoder.encode(obj.getPassword()));
        return userRepository.save(obj);
    }

    @Override
    public Users findById(String id) {
        return null;
    }

    @Override
    public Users update(String id, Users obj) {
        return null;
    }
}
