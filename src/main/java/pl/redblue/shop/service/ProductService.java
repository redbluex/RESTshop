package pl.redblue.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.redblue.shop.domain.Product;
import pl.redblue.shop.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService implements ServiceInterface<Product> {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getObjects() {
        List<Product> list = productRepository.findAll();
        return list;
    }

    @Override
    public Product create(Product obj) {
        return productRepository.save(obj);
    }

    @Override
    public Product findById(String id) {
        Product product = productRepository.findById(id).get();
        return product;
    }

    @Override
    public Product update(String id, Product obj) {
        Product product = productRepository.findById(id).get();
        product.setCategory(obj.getCategory());
        product.setDescription(obj.getDescription());
        product.setName(obj.getName());
        product.setPhoto(obj.getPhoto());
        product.setPrice(obj.getPrice());
        product.setQuantity(obj.getQuantity());
        productRepository.save(product);
        return product;
    }

    public void deleteProduct(String id){
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }
}
