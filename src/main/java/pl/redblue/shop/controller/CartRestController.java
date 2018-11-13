package pl.redblue.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.redblue.shop.domain.Cart;
import pl.redblue.shop.service.CartService;


import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/cart/")
public class CartRestController {

    @Autowired
    CartService cartService;

    //All carts
    @GetMapping("/allcarts")
    public List<Cart> allCarts(){
        return cartService.getObjects();
    }

    //Cart found by id
    @GetMapping("/single/{id}")
    public Cart getCartById(@PathVariable String id, Principal principal){
        return cartService.findById(id, principal);
    }

    @PostMapping("/single/create/{productId}")
    public Cart createCart(@PathVariable String productId, Principal principal){
        return cartService.create(productId, principal);
    }

    //deleting cart by id
    @PostMapping("/single/{id}/delete")
    public void deleteCart(@PathVariable String id){
        cartService.deleteCart(id);
    }

    //adding a product to cart
    @PostMapping("/single/{id}/addproduct/{productId}")
    public void addProductToCart(@PathVariable String id, @PathVariable String productId, Principal principal){
        cartService.addProduct(id, productId, principal);
    }

    //deleting a product(s) from cart
    @PostMapping("/single/{id}/deleteproduct/{productId}")
    public void deleteProductInCart(@PathVariable String id, @PathVariable String productId, Principal principal){
        cartService.deleteProduct(id, productId, principal);
    }

    @GetMapping("/single/{id}/sum")
    public double sumOfProducts(@PathVariable String id){
        return cartService.sumOfProducts(id);
    }

}
