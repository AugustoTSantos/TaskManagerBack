package selaz.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import selaz.api.entity.association.Association;

import java.util.Optional;

public interface AssociationRepository extends JpaRepository<Association, Long> {
    Optional<Association> findByAssId(Long id);
}
