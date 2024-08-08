package selaz.api.entity.user;

import jakarta.persistence.*;
import lombok.Data;

@Data
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
}
