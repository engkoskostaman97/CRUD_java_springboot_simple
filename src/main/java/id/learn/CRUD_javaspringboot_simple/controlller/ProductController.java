package id.learn.CRUD_javaspringboot_simple.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import id.learn.CRUD_javaspringboot_simple.model.Product;
import id.learn.CRUD_javaspringboot_simple.service.ProductService;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/api/products")
public class ProductController {

@Autowired
private ProductService productService;

@GetMapping
public ResponseEntity<List<Product>> getAllProducts() {
return new ResponseEntity<>(productService.findAllProducts(),
HttpStatus.OK);
}

@PostMapping
public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product
product) {
return new ResponseEntity<>(productService.saveorUpdateProduct(product),
HttpStatus.OK);
}

@PutMapping("{id}")
public ResponseEntity<Product> updateUser(@PathVariable("id") Long productId,
  @Valid @RequestBody Product product){
    product.setId(productId);
    return new ResponseEntity<Product>(productService.updateProduct(product),
    HttpStatus.OK
    );
}




@GetMapping("/{id}")
public ResponseEntity<Product> getOneProduct(@PathVariable Long id) throws
Exception {
return new ResponseEntity<Product>(productService.findProductById(id),
HttpStatus.OK);
}

@DeleteMapping("/{id}")
public String deleteProduct(@PathVariable Long id) {
productService.deleteProduct(id);
return "delete sukses";
}
}
