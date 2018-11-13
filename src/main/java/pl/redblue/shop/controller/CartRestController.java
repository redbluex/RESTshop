package pl.redblue.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.redblue.shop.domain.Cart;
import pl.redblue.shop.service.CartService;


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
    public Cart getCartById(@PathVariable String id){
        return cartService.findById(id);
    }

    //deleting cart by id
    @PostMapping("/single/{id}/delete")
    public void deleteCart(@PathVariable String id){
        cartService.deleteCart(id);
    }

    //adding a product to cart
    @PostMapping("/single/{id}/addproduct/{productId}")
    public void addProductToCart(@PathVariable String id, @PathVariable String productId){
        cartService.addProduct(id, productId);
    }

    //deleting a product(s) from cart
    @PostMapping("/single/{id}/deleteproduct/{productId}")
    public void deleteProductInCart(@PathVariable String id, @PathVariable String productId){
        cartService.deleteProduct(id, productId);
    }

    @GetMapping("/single/{id}/sum")
    public double sumOfProducts(@PathVariable String id){
        return cartService.sumOfProducts(id);
    }

}
