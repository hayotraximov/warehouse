package uz.raximov.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.raximov.demo.Entity.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    Optional<Client> findByPhoneNumber(String phoneNumber);
}
