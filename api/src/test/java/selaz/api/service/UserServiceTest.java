package selaz.api.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import selaz.api.dto.UserDTO;
import selaz.api.entity.user.User;
import selaz.api.entity.user.UserNivel;
import selaz.api.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserServiceTest {
    @Mock
    private User user;

    @Mock
    private UserNivel userNivel;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserDTO userDTO;

    @Autowired
    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Should return all users")
    void getAllUsersCase1() {

    }

    @Test
    void saveUser() {
    }

    @Test
    void createUser() {
    }

    @Test
    void getUserById() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}
