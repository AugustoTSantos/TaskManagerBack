package selaz.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import selaz.api.entity.association.Association;

public interface AssociationRepository extends JpaRepository<Association, Long> {
}
