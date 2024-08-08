package selaz.api.entity.task;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import selaz.api.dto.TaskDTO;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tas_task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tas_id")
    private Long tasId;

    @Column(name = "tas_title", nullable = false)
    private String tasTitle;

    @Column(name = "tas_description", nullable = false)
    private String tasDescription;

    @Column(name = "tas_created_at", nullable = false)
    private Date tasCreatedAt;

    @Column(name = "tas_due_date", nullable = false)
    private Date tasDueDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "tas_status", nullable = false)
    private TaskStatus tasStatus;

    // DTO constructor, for creating new users
    public Task(TaskDTO taskDTO) {
        this.tasTitle = taskDTO.tasTitle();
        this.tasDescription = taskDTO.tasDescription();
        this.tasCreatedAt = taskDTO.tasCreatedAt();
        this.tasDueDate = taskDTO.tasDueDate();
        this.tasStatus = taskDTO.tasStatus();
    }
}
