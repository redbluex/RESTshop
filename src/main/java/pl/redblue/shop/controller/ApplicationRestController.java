package pl.redblue.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.redblue.shop.domain.Product;
import pl.redblue.shop.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ApplicationRestController {

    @Autowired
    ProductService productService;

    @RequestMapping("/allproducts")
    public List<Product> showAllProducts(){
        return productService.getObjects();
    }

    @PostMapping("/add")
    public @ResponseBody
    Product putProduct(@RequestBody Product product){
        return productService.create(product);
    }

    @GetMapping("/single/{id}")
    public Product getProductById(@PathVariable String id){
        return productService.findById(id);
    }

    @PostMapping("/update/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product product){
        return productService.update(id, product);
    }

    @PostMapping("/delete/{id}")
    public void deleteProduct(@PathVariable String id){
        productService.deleteProduct(id);
    }

}
