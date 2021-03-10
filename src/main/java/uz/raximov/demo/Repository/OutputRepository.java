package uz.raximov.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.raximov.demo.Entity.Output;

public interface OutputRepository extends JpaRepository<Output, Integer> {
}
