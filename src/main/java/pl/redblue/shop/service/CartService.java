package pl.redblue.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.redblue.shop.domain.Cart;
import pl.redblue.shop.domain.Product;
import pl.redblue.shop.repository.CartRepository;
import pl.redblue.shop.repository.ProductRepository;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;


    public List<Cart> getObjects() {
        return cartRepository.findAll();
    }


    public Cart create(String idProduct, Principal principal) {
        Product product = productRepository.findById(idProduct).get();
        List<Product> products = new ArrayList<>();
        products.add(product);
        Cart cart = new Cart(products, principal.getName());
        cartRepository.save(cart);
        return cart;
    }


    public Cart findById(String id) {
        Cart cart = cartRepository.findById(id).get();
        return cart;
    }


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
