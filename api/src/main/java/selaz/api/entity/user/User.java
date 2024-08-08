package selaz.api.entity.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import selaz.api.dto.UserDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "use_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "use_id")
    private Long useId;

    @Column(name = "use_username", nullable = false, unique=true, length=50)
    private String useUsername;

    @Column(name = "use_password", nullable = false, length = 50)
    private String usePassword;

    @Enumerated(EnumType.STRING)
    @Column(name = "use_nivel", nullable = false, length = 4)
    private UserNivel useNivel;

    // DTO constructor, for creating new users
    public User(UserDTO userDTO) {
        this.useUsername = userDTO.useUsername();
        this.usePassword = userDTO.usePassword();
        this.useNivel = userDTO.useNivel();
    }
}
