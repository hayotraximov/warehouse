package uz.raximov.demo.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.raximov.demo.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
