package id.learn.CRUD_javaspringboot_simple.service.impl;

import id.learn.CRUD_javaspringboot_simple.model.Product;
import id.learn.CRUD_javaspringboot_simple.repository.ProductRepository;
import id.learn.CRUD_javaspringboot_simple.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

@Autowired
ProductRepository productRepository;

@Override
public List<Product> findAllProducts() {
return productRepository.findAll();
}

@Override
public Product findProductById(Long id) throws Exception {
Product product = productRepository.findById(id).orElse(new Product());
return product;
}

@Override
public Product saveorUpdateProduct(Product product) {
return productRepository.save(product);
}

@Override
public Product updateProduct(Product product) {
    Product existingProduct = productRepository.findById(product.getId()).get();
    existingProduct.setNama(product.getNama());
    existingProduct.setHargaBeli(product.getHargaBeli());
    existingProduct.setHargaJual(product.getHargaJual());
    Product updatedUser = productRepository.save(existingProduct);
    return updatedUser;
}


@Override
public void deleteProduct(Long id) {
Product product = productRepository.findById(id).orElse(new Product());
productRepository.delete(product);
}


}