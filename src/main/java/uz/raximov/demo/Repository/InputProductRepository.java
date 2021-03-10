package uz.raximov.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.raximov.demo.Entity.InputProduct;

public interface InputProductRepository extends JpaRepository<InputProduct, Integer> {
}
