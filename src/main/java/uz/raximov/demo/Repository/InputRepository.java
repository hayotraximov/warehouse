package uz.raximov.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.raximov.demo.Entity.Input;

public interface InputRepository extends JpaRepository<Input, Integer> {
}
