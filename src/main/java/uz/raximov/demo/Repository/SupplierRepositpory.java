package uz.raximov.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.raximov.demo.Entity.Supplier;

import java.util.Optional;

public interface SupplierRepositpory extends JpaRepository<Supplier, Integer> {
    Optional<Supplier> findByPhoneNumber(String phoneNumber);
}
