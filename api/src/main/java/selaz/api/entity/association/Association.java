package selaz.api.entity.association;

import jakarta.persistence.*;
import lombok.Data;
import selaz.api.entity.user.User;
import selaz.api.entity.task.Task;

@Data
@Entity
@Table(name = "ass_association")
public class Association {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ass_id")
    private Long assId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ass_use_id", referencedColumnName = "use_id")
    private User assUseId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ass_tas_id", referencedColumnName = "tas_id")
    private Task assTasId;
}
