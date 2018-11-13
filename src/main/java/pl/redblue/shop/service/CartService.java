package pl.redblue.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.redblue.shop.domain.Cart;
import pl.redblue.shop.domain.Product;
import pl.redblue.shop.repository.CartRepository;
import pl.redblue.shop.repository.ProductRepository;

import java.util.List;

@Service
public class CartService implements ServiceInterface<Cart> {

    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Cart> getObjects() {
        return cartRepository.findAll();
    }

    @Override
    public Cart create(Cart obj) {
        cartRepository.save(obj);
        return obj;
    }

    @Override
    public Cart findById(String id) {
        Cart cart = cartRepository.findById(id).get();
        return cart;
    }

    @Override
    public Cart update(String id, Cart obj) {
        return null;
    }

    public void deleteCart(String id){
        productRepository.deleteById(id);
    }

    public void deleteProduct(String id, String productId){
        Cart cart = cartRepository.findById(id).get();
        cart.getProducts().removeIf(obj -> obj.getId().equals(productId));
        cartRepository.save(cart);
    }

    public void addProduct(String id, String productId) {
        Cart cart = cartRepository.findById(id).get();
        Product product = productRepository.findById(productId).get();
        cart.getProducts().add(product);
        cartRepository.save(cart);
    }

    public double sumOfProducts(String id) {
        Cart cart = cartRepository.findById(id).get();
        return cart.getProducts().stream().mapToDouble(x->x.getPrice())
                .sum();

    }
}
