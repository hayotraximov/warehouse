package uz.raximov.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.raximov.demo.Entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
}
