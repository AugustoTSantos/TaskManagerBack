package selaz.api.repository;

import jakarta.persistence.EntityManager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

import selaz.api.dto.UserDTO;
import selaz.api.entity.user.User;
import selaz.api.entity.user.UserNivel;

import java.util.Optional;

@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    @DisplayName("Should return user successfully")
    void findByUseIdCase1() {
        UserDTO userDTO = new UserDTO(
                "test1",
                "123",
                UserNivel.ADM
        );

        createUser(userDTO);

        Optional<User> result = this.userRepository.findByUseId(1L);

        assertThat(result.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Should not get a non existent user")
    void findByUseIdCase2() {
        Optional<User> result = this.userRepository.findByUseId(1L);

        assertThat(result.isEmpty()).isTrue();
    }

    // Auxiliary Methods
    private User createUser(UserDTO userDTO) {
        User newUser = new User(userDTO);
        this.entityManager.persist(newUser);
        return newUser;
    }
}
