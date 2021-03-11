package uz.raximov.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.raximov.demo.Entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByPhoneNumber(String phoneNumber);

    Optional<User> findByChatId(Long chatId);
}
