package bookstation.book.models.repository;

import bookstation.book.models.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagesRepository extends JpaRepository<Images,Long> {
}
