package uz.raximov.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.raximov.demo.Entity.Measurement;

import java.util.Optional;

public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {

    Optional<Measurement> findByName(String name);
}
