package id.learn.CRUD_javaspringboot_simple.repository;

import id.learn.CRUD_javaspringboot_simple.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<Product, Long> {
}