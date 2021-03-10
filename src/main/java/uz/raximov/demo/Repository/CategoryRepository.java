package uz.raximov.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.raximov.demo.Entity.Category;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByName(String name);
}
