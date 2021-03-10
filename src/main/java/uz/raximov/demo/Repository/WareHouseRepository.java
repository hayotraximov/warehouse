package uz.raximov.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.raximov.demo.Entity.Warehouse;

import java.util.Optional;

public interface WareHouseRepository  extends JpaRepository<Warehouse, Integer> {

    Optional<Warehouse> findByName(String name);
}
