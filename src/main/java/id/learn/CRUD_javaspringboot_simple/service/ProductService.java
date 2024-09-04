package id.learn.CRUD_javaspringboot_simple.service;
import id.learn.CRUD_javaspringboot_simple.model.Product;

import java.util.List;

public interface ProductService {
List<Product> findAllProducts();
Product findProductById(Long id) throws Exception;
Product saveorUpdateProduct(Product product);
Product updateProduct(Product product);
void deleteProduct(Long id);

}