package uz.raximov.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.raximov.demo.Entity.OutputProduct;

public interface OutputProductRepository extends JpaRepository<OutputProduct, Integer> {
}
