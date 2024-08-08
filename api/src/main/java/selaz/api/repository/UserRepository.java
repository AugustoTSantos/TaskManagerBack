package selaz.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import selaz.api.entity.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUseId(Long useId);
}
